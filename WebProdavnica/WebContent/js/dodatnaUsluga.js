/**
 * 
 */
function DodatnaUsluga(){
	this.naziv;
	this.opis;
	this.cena;

	DodatnaUsluga.prototype.setNaziv = function(naziv) {
		this.naziv = naziv;
	}	
	DodatnaUsluga.prototype.getNaziv = function() {
		return this.naziv;
	}
	DodatnaUsluga.prototype.setOpis = function(opis) {
		this.opis = opis;
	}
	DodatnaUsluga.prototype.getOpis = function() {
		return this.opis;
	}
	DodatnaUsluga.prototype.setCena = function(cena) {
		this.cena = cena;
	}
	DodatnaUsluga.prototype.getCena = function() {
		return this.cena;
	}
	DodatnaUsluga.prototype.fillData = function(naziv,opis,cena) {
		this.naziv =$(naziv).val();
		this.opis =$(opis).val();
		this.cena =$(cena).val();
		console.log(this.naziv + ' - ' + this.cena);
		$.ajax({
			dataType: 'json',
			contentType: 'application/json',
			mimeType: 'application/json',
			url: 'AddDodatnaUsluga',
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
	DodatnaUsluga.prototype.fillDataEdit = function(naziv,opis,cena) {
		this.naziv =$(naziv).val();
		this.opis =$(opis).val();
		this.cena =$(cena).val();
		console.log(this.naziv + ' - ' + this.cena);
		$.ajax({
			dataType: 'json',
			contentType: 'application/json',
			mimeType: 'application/json',
			url: 'EditDodatnaUsluga',
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
	DodatnaUsluga.prototype.searchDU = function(polje,vrednost) {
		this.naziv =$(naziv).val();
		this.opis =$(opis).val();
		this.cena =$(cena).val();
		console.log(this.naziv + ' - ' + this.cena);
		$.ajax({
			dataType: 'json',
			contentType: 'application/json',
			mimeType: 'application/json',
			url: 'EditDodatnaUsluga',
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