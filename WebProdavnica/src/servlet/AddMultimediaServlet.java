package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.JsonObject;
/**
 * Servlet implementation class AddMultimediaServlet
 */
public class AddMultimediaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 500 * 1024;
	private int maxMemSize = 400 * 1024;
	private File file ;
	public AddMultimediaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")==null)
			response.sendRedirect("./LoginForm.jsp");
		filePath = getServletContext().getInitParameter("file-upload"); 
		isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("aplication/json");

		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);
		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("c:\\temp"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum file size to be uploaded.
		upload.setSizeMax( maxFileSize );

		try{ 
			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();

			String uplaodedLink = filePath;
			while ( i.hasNext () ) 
			{
				FileItem fi = (FileItem)i.next();
				if ( !fi.isFormField () )	
				{
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					// Write the file
					if( fileName.lastIndexOf("\\") >= 0 ){
						file = new File( filePath + 
								fileName.substring( fileName.lastIndexOf("\\"))) ;
					}else{
						file = new File( filePath + 
								fileName.substring(fileName.lastIndexOf("\\")+1)) ;
					}
					fi.write( file ) ;
					uplaodedLink= uplaodedLink+file.getName();

				}
			}
			JsonObject json = new JsonObject();
			json.addProperty("linkURL", uplaodedLink);
			response.getWriter().print(json);
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}

}
