/**
 * Define class Korisnik
 */
function Korisnik() {
	this.korisnickoIme;
	this.lozinka;
	Korisnik.prototype.setKorisnickoIme = function(korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	Korisnik.prototype.setLozinka = function(lozinka) {
		this.lozinka = lozinka;
	}
	Korisnik.prototype.getKorisnickoIme = function() {
		return this.korisnickoIme;
	}
	Korisnik.prototype.getLozinka = function() {
		return this.lozinka;
	}
	Korisnik.prototype.loginKorisnika = function(usernameSelector, passwordSelector) {
		this.korisnickoIme = $(usernameSelector).val();
		this.lozinka = $(passwordSelector).val();
		console.log(this.korisnickoIme + ' - ' + this.lozinka);
		$.ajax({
			dataType: 'json',
			contentType: 'application/json',
			mimeType: 'application/json',
			url: 'LoginUserServlet',
			type: 'POST',
			data: JSON.stringify(korisnik),
			success: function(data) {
				console.log(data);
				window.location = data.url;
			},
			error: function(data,status,er) {
	            alert("error: " + data + " status: " + status + " er:" + er);
	        }
		});
	}
	Korisnik.prototype.loginAdminKorisnika = function(usernameSelector, passwordSelector) {
		//this.korisnickoIme = $(usernameSelector).val();
		//this.lozinka = $(passwordSelector).val();
		setKorisnickoIme(usernameSelector);
		setLozinka(passwordSelector);
		console.log(this.korisnickoIme + ' - ' + this.lozinka);
		$.ajax({
			dataType: 'json',
			contentType: 'application/json',
			mimeType: 'application/json',
			url: 'LoginAdminServlet',
			type: 'POST',
			data: JSON.stringify(korisnik),
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

// create new instance of class Korisnik
// needed for login page
var korisnik = new Korisnik();
