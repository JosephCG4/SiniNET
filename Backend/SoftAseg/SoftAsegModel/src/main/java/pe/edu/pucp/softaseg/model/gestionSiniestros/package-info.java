@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(
        type = java.time.LocalDateTime.class,
        value = pe.edu.pucp.softaseg.model.util.LocalDateTimeAdapter.class
    )
})
package pe.edu.pucp.softaseg.model.gestionSiniestros;

import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

