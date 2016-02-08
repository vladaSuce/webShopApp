/**
 * 
 */
/**
 * 
 * 		this.naziv =$(naziv).val();
		this.opis =$(opis).val();
		this.cena =$(cena).val();
 */

function ModelPretrageDTO(){
	this.naziv;
	this.opis;
	this.minCena;
	this.maxCena;
	this.raspolozivaKolicina;
	this.tip;
	this.zemljaProizvodnje;
	this.godiniProizvodnje;
	this.boja;
	this.nazivProizvodjaca;
	this.tipPretrage;
	
	Kategorija.prototype.fillData = function(tipPretrage,naziv,opis,minCena,maxCena,raspolozivaKolicina,
			tip,zemljaProizvodnje,godiniProizvodnje,boja,nazivProizvodjaca) {
		this.tipPretrage =$(tipPretrage).val();
		this.naziv =$(naziv).val();
		this.opis =$(opis).val();
		this.minCena =$(minCena).val();
		this.maxCena =$(maxCena).val();
		this.raspolozivaKolicina =$(raspolozivaKolicina).val();
		this.tip =$(tip).val();
		this.zemljaProizvodnje =$(zemljaProizvodnje).val();
		this.godiniProizvodnje =$(godiniProizvodnje).val();
		this.boja =$(boja).val();
		this.nazivProizvodjaca =$(nazivProizvodjaca).val();
		$.ajax({
			dataType: 'json',
			contentType: 'application/json',
			mimeType: 'application/json',
			url: servlet,
			type: 'POST',
			data: JSON.stringify(pretraga),
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
var pretraga = new ModelPretrageDTO();