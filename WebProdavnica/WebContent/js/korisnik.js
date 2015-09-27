/**
 * Define class Korisnik
 */
function Korisnik() {
	this.korisnickoIme;
	this.lozinka;
	this.uloga;
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
	Korisnik.prototype.setUloga = function(uloga) {
		this.uloga = uloga;
	}
	Korisnik.prototype.getUloga = function() {
		return this.uloga;
	}
	Korisnik.prototype.proveriPolje = function(ovajElement, errorSelector) {
		if (ovajElement.val() != '') {
			
		}
	}
	Korisnik.prototype.loginKorisnika = function(usernameSelector, passwordSelector) {
		this.korisnickoIme = $(usernameSelector).val();
		this.lozinka = $(passwordSelector).val();

		console.log(this.korisnickoIme + ' - ' + this.lozinka);
		if (this.korisnickoIme == '' || this.korisnickoIme == null) {
			$('#usernameLoginError').show();
		}
		if (this.lozinka == '' || this.lozinka == null) {
			$('#passwordLoginError').show();
		}
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
		this.korisnickoIme = $(usernameSelector).val();
		this.lozinka = $(passwordSelector).val();
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
var uloga = $('#ulogaKorisnika').val();
korisnik.setUloga(uloga);

