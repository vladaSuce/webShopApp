/**
 * 
 */

function Kategorija(){
	this.naziv;
	this.opis;
	this.podKategorija;
	
	Kategorija.prototype.setNaziv = function(naziv) {
		this.naziv=naziv;
	}
	Kategorija.prototype.getNaziv = function() {
		return this.naziv;
	}
	Kategorija.prototype.setOpis = function(opis) {
		this.opis = opis;
	}
	Kategorija.prototype.getOpis = function() {
		return this.opis;
	}
	Kategorija.prototype.setPodKategorija = function(podKategorija) {
		this.podKategorija= podKategorija;
	}
	Kategorija.prototype.getPodKategorija = function() {
		return this.podKategorija;
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
}
var kategorija = new Kategorija();