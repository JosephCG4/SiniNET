function showModalMapas() {
    var modalFormGrupo = new bootstrap.Modal(document.getElementById('form-modal-mapa'));
    modalFormGrupo.show();

    // Espera un poco para que el modal se renderice antes de cargar el mapa
    setTimeout(function () {
        initMap();
    }, 300);
}

function initMap() {
    // Centra el mapa en Lima
    var map = L.map('map').setView([-12.0464, -77.0428], 13);

    // Capa base de OpenStreetMap
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '&copy; OpenStreetMap contributors'
    }).addTo(map);

    // Variable para el marcador
    var marker;

    // Detectar clics en el mapa
    map.on('click', function (e) {
        var lat = e.latlng.lat.toFixed(6);
        var lng = e.latlng.lng.toFixed(6);

        // Si ya hay un marcador, lo mueve; si no, lo crea
        if (marker) {
            marker.setLatLng(e.latlng);
        } else {
            marker = L.marker(e.latlng).addTo(map);
        }

        // Asigna las coordenadas a los TextBox
        document.getElementById('txtLatitud').value = lat;
        document.getElementById('txtLongitud').value = lng;
    });

    // Ajusta el tamaño cuando el modal se abre
    setTimeout(function () {
        map.invalidateSize();
    }, 400);
}

