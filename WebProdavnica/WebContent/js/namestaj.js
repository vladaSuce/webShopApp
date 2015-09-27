
/**
 * Define class Namestaj
 */
function Namestaj() {
	this.sifra;
	this.naziv;
	this.boja;
	this.zemljaProizvodnje;
	this.nazivProizvodjaca;
	this.jedinicnaCena;
	this.kolicinaUMagacinu;
	this.godinaProizvodnje;
	this.namestajiKategorije;
	this.helper = new Helper();

	Namestaj.prototype.setSifra = function(sifra) {
		this.sifra = sifra;
	}
	Namestaj.prototype.getSifra = function() {
		return this.sifra;
	}
	Namestaj.prototype.getNaziv = function() {
		return this.naziv;
	}
	Namestaj.prototype.setNaziv = function(naziv) {
		this.naziv=naziv;
	}
	Namestaj.prototype.getBoja = function() {
		return this.boja;
	}
	Namestaj.prototype.setBoja = function(boja) {
		this.boja=boja;
	}
	Namestaj.prototype.getZemljaProizvodnje  = function() {
		return this.zemljaProizvodnje;
	}
	Namestaj.prototype.setZemljaProizvodnje  = function(zemljaProizvodnje) {
		this.zemljaProizvodnje=zemljaProizvodnje;
	}
	Namestaj.prototype.getNazivProizvodjaca = function() {
		return this.nazivProizvodjaca;
	}
	Namestaj.prototype.setNazivProizvodjaca = function(nazivProizvodjaca) {
		this.nazivProizvodjaca=nazivProizvodjaca;
	}
	Namestaj.prototype.getJedinicnaCena = function() {
		return this.jedinicnaCena;
	}
	Namestaj.prototype.setJedinicnaCena = function(jedinicnaCena){
		this.jedinicnaCena=jedinicnaCena;
	}
	Namestaj.prototype.getKolicinaUMagacinu = function() {
		return this.kolicinaUMagacinu;
	}
	Namestaj.prototype.setKolicinaUMagacinu = function(kolicinaUMagacinu) {
		this.kolicinaUMagacinu=kolicinaUMagacinu;
	}
	Namestaj.prototype.getGodinaProizvodnje = function() {
		return this.godinaProizvodnje;
	}
	Namestaj.prototype.setGodinaProizvodnje = function(godinaProizvodnje) {
		this.godinaProizvodnje=godinaProizvodnje;
	}
	Namestaj.prototype.getNamestajKategorije = function() {
		return this.namestajiKategorije;
	}
	Namestaj.prototype.setNamestajKategorije = function(namestajiKategorije) {
		this.namestajiKategorije = namestajiKategorije;
	}
	
	
	Namestaj.prototype.collectData = function(asifra,anaziv,aboja,azemljaProizvodnje,anazivProizvodjaca
												,ajedinicnaCena,akolicinaUMagacinu,agodinaProizvodnje) {
		setBoja(aboja);
		setGodinaProizvodnje(agodinaProizvodnje);
		setKolicinaUMagacinu(akolicinaUMagacinu);
		setNaziv(anaziv);
		setNazivProizvodjaca(anazivProizvodjaca);
		setSifra(asifra);
		setZemljaProizvodnje(azemljaProizvodnje);
		setJedinicnaCena(ajedinicnaCena)

		$.ajax({
			dataType: 'json',
			contentType: 'application/json',
			mimeType: 'application/json',
			url: 'LoginUserServlet',
			type: 'POST',
			data: JSON.stringify(namestaj),
			success: function(data) {
				console.log(data);
				window.location = data.url;
			},
			error: function(data,status,er) {
	            alert("error: " + data + " status: " + status + " er:" + er);
	        }
		});
	}

	Namestaj.prototype.getNamestajZaKategoriju = function(nazivKategorije) {
		$.ajax({
			dataType: 'json',
			contentType: 'application/json',
			mimeType: 'application/json',
			url: 'KategorijaNamestajServlet?name=' + nazivKategorije,
			type: 'GET',
			beforeSend: function() {
				$("#namestaj-items-root").hide();
				$("#namestaj-items-root").empty();
			},
			success: function(data) {
				namestaj.setNamestajKategorije(data);
				renderNamestajList();
			},
			error: function(data,status,er) {
				alert("error: " + data + " status: " + status + " er:" + er);
			}
		});
	}

	Namestaj.prototype.prikaziPodatkeZaKomadNamestaja = function(naziv) {
		var komadNamestajaZaPrikaz = this.helper.getObjectFromArray(this.namestajiKategorije, 'naziv', naziv);
		console.log(komadNamestajaZaPrikaz);
		renderDetailSection(komadNamestajaZaPrikaz);
	}

	function renderNamestajList() {
		var markup = '<hr>' +
			'<div class="row">' +
			'<div class="col-md-12">' +
			'<span class="pull-right">${kolicinaUMagacinu} komad(a)</span>' +
			'<a href="javascript:;" onclick="namestaj.prikaziPodatkeZaKomadNamestaja(\'${naziv}\')">${naziv}</a>' +
			'</div>' +
			'</div>';

		// Compile the markup as a named template
		$.template("namestajTemplate", markup);

		// Render the template with the movies data and insert
		// the rendered HTML under the "movieList" element
		$("#namestaj-items-root").show();
		$.tmpl("namestajTemplate", namestaj.getNamestajKategorije()).appendTo("#namestaj-items-root");
	}

	function renderDetailSection(detail) {
		$('#detail-placeholder').empty();
		var markup = '<img class="img-responsive" src="http://placehold.it/800x300" alt="">' +
			'<div class="caption-full">' +
			'<h4>${naziv}</h4><h4 class="pull-right">${jedinicnaCena} (din.)</h4>' +
			'<p>Naziv proizvodjaca ${nazivProizvodjaca}' +
			'<br>Godina proizvodnje: ${godinaProizvodnje}' +
			'<br>Boja: ${boja}</p>' +
			'</div>';

		// Compile the markup as a named template
		$.template("namestajDetailTemplate", markup);

		// Render the template with the movies data and insert
		// the rendered HTML under the "movieList" element
		$('#detail-placeholder').show();
		$.tmpl("namestajDetailTemplate", detail).appendTo("#detail-placeholder");
	}
	
}

// create new instance of class Namestaj
var namestaj = new Namestaj();
