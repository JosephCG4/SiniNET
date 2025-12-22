
function showMapaVer(lat, lng) {
    // Abre el modal
    var modal = new bootstrap.Modal(document.getElementById('form-modal-mapa-ver'));
    modal.show();

    setTimeout(function () {
        // Inicializa el mapa
        var map = L.map('mapViewVer').setView([lat, lng], 16);

        // Agrega la capa base
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            maxZoom: 19,
            attribution: '&copy; OpenStreetMap contributors'
        }).addTo(map);

        // Agrega marcador fijo
        L.marker([lat, lng]).addTo(map);

        // Ajusta el tamaño del mapa dentro del modal
        setTimeout(() => map.invalidateSize(), 400);
    }, 300);
}

function modalVerCentroSalud(lat, lng) {
    // Abre el modal
    var modal = new bootstrap.Modal(document.getElementById('modalVerCentroDeSalud'));
    modal.show();

    setTimeout(function () {
        // Inicializa el mapa
        var map = L.map('mapViewVer2').setView([lat, lng], 16);

        // Agrega la capa base
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            maxZoom: 19,
            attribution: '&copy; OpenStreetMap contributors'
        }).addTo(map);

        // Agrega marcador fijo
        L.marker([lat, lng]).addTo(map);

        // Ajusta el tamaño del mapa dentro del modal
        setTimeout(() => map.invalidateSize(), 400);
    }, 300);
}

function modalVerTaller(lat, lng) {
    // Abre el modal
    var modal = new bootstrap.Modal(document.getElementById('modalVerTaller'));
    modal.show();

    setTimeout(function () {
        // Inicializa el mapa
        var map = L.map('mapViewVer3').setView([lat, lng], 16);

        // Agrega la capa base
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            maxZoom: 19,
            attribution: '&copy; OpenStreetMap contributors'
        }).addTo(map);

        // Agrega marcador fijo
        L.marker([lat, lng]).addTo(map);

        // Ajusta el tamaño del mapa dentro del modal
        setTimeout(() => map.invalidateSize(), 400);
    }, 300);
}