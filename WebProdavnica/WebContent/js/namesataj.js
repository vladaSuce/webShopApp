
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
	
}

// create new instance of class Namestaj
var namestaj = new Namestaj();
