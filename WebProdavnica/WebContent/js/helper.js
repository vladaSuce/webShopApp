/**
 * Created by novica.pilipovic on 26.9.2015.
 */

function Helper() {
    Helper.prototype.getObjectFromArray = function(lista, atributPretrage, vrednostAtributa) {
        for (var i in lista) {
            var object = lista[i];
            if (object[atributPretrage] == vrednostAtributa) {
                return object;
            }
        }
    }
}