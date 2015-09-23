/**
 * 
 */
function Kategorija(){
	this.naziv;
	this.opis;
	this.podKategorija;
	
	Kategorija.prototype.setNaziv(naziv){
		this.naziv=naziv;
	}
	Kategorija.prototype.getNaziv(){
		return this.naziv;
	}
	Kategorija.prototype.setOpis(opis){
		this.opis = opis;
	}
	Kategorija.prototype.getOpis(){
		return this.opis;
	}
	Kategorija.prototype.setPodKategorija(podKategorija){
		this.podKategorija= podKategorija;
	}
	Kategorija.prototype.getPodKategorija(){
		return this.podKategorija;
	}
	Kategorija.prototype.fillData(naziv,opis,podKategorija,servlet){
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
var kategorija = new Kategorija()