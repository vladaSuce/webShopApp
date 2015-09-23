/**
 * 
 */
function DodatnaUsluga(){
	this.naziv;
	this.opis;
	this.cena;

	DodatnaUsluga.prototype.setNaziv(naziv){
		this.naziv = naziv;
	}	
	DodatnaUsluga.prototype.getNaziv(){
		return this.naziv;
	}
	DodatnaUsluga.prototype.setOpis(opis){
		this.opis = opis;
	}
	DodatnaUsluga.prototype.getOpis(){
		return this.opis;
	}
	DodatnaUsluga.prototype.setCena(cena){
		this.cena = cena;
	}
	DodatnaUsluga.prototype.getCena(){
		return this.cena;
	}
	DodatnaUsluga.prototype.fillData(naziv,opis,cena,servlet){
		setNaziv(naziv);
		setCena(cena);
		setOpis(opis);
		$.ajax({
			dataType: 'json',
			contentType: 'application/json',
			mimeType: 'application/json',
			url: servlet,
			type: 'POST',
			data: JSON.stringify(dodatnaUsluga),
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

var dodatnaUsluga = new DodatnaUsluga();