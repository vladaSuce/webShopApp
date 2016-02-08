/**
 * 
 * 		this.naziv =$(naziv).val();
		this.opis =$(opis).val();
		this.cena =$(cena).val();
 */

function Kategorija(){
	this.naziv;
	this.opis;
	this.podKategorija;
	this.nadKategorija;
	
	Kategorija.prototype.setNaziv = function(naziv) {
		this.naziv =$(naziv).val();
	}
	Kategorija.prototype.getNaziv = function() {
		return this.naziv;
	}
	Kategorija.prototype.setOpis = function(opis) {
		this.opis =$(opis).val();
	}
	Kategorija.prototype.getOpis = function() {
		return this.opis;
	}
	Kategorija.prototype.setPodKategorija = function(podKategorija) {
		this.podKategorija =$(podKategorija).val();
	}
	Kategorija.prototype.getPodKategorija = function() {
		return this.podKategorija;
	}
	Kategorija.prototype.getNadKategorija = function() {
		return this.nadKategorija;
	}
	Kategorija.prototype.setNadKategorija = function(nadKategorija) {
		this.nadKategorija =$(nadKategorija).val();
	}
	Kategorija.prototype.fillData = function(naziv,opis,podKategorija,servlet) {
		setNaziv(naziv);
		setOpis(opis);
		setPodKategorija(podKategorija);
		$.ajax({
			dataType: 'json',
			contentType: 'application/json',
			mimeType: 'application/json',
			url: servlet,
			type: 'POST',
			data: JSON.stringify(kategorija),
			success: function(data) {
				console.log(data);
				window.location = data.url;
			},
			error: function(data,status,er) {
	            alert("error: " + data + " status: " + status + " er:" + er);
	        }
		});
	}
	Kategorija.prototype.fillDataInsert = function(naziv,opis,nadKategorija) {
		console.log(this.naziv + ' - ' + this.opis+ ' - ' + this.nadKategorija);
		this.naziv =$(naziv).val();
		this.opis =$(opis).val();
		this.nadKategorija =$(nadKategorija).val();
		$.ajax({
			dataType: 'json',
			contentType: 'application/json',
			mimeType: 'application/json',
			url: 'AddKategorijaServlet',
			type: 'POST',
			data: JSON.stringify(kategorija),
			success: function(data) {
				console.log(data);
				window.location = data.url;
			},
			error: function(data,status,er) {
	            alert("error: " + data + " status: " + status + " er:" + er);
	        }
		});
	}
	Kategorija.prototype.getSubkategorijeZaKategoriju = function(element, nazivKategorije) {
		$.ajax({
			dataType: 'json',
			contentType: 'application/json',
			mimeType: 'application/json',
			url: 'KategorijaNamestajServlet?kategorija=' + nazivKategorije,
			type: 'GET',
			beforeSend: function() {
				$("#namestaj-items-root").hide();
				$("#namestaj-items-root").empty();
			},
			success: function(data) {
				console.log(data);
				var markup = '<li>${naziv}</li>';

				// Compile the markup as a named template
				$.template("submenuTemplate", markup);

				// Render the template with the movies data and insert
				// the rendered HTML under the "movieList" element
				$("#namestaj-items-root").show();
				$.tmpl("submenuTemplate", data).appendTo($(element).next());
			},
			error: function(data,status,er) {
				alert("error: " + data + " status: " + status + " er:" + er);
			}
		});
	}
	Kategorija.prototype.otvoriZatvoriSubmenu = function (selektor) {
		$(selektor).fadeToggle();
	}
}
var kategorija = new Kategorija();