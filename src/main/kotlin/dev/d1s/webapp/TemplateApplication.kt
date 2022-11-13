package dev.d1s.webapp

import dev.d1s.webapp.component.pointReporter
import io.kvision.*
import io.kvision.core.Background
import io.kvision.core.Col
import io.kvision.core.Color
import io.kvision.panel.root
import io.kvision.utils.perc

class TemplateApplication : Application() {

    override fun start() {
        root("root") {
            width = 100.perc
            background = Background(Color.name(Col.BLACK))

            pointReporter()
        }
    }
}

fun main() {
    startApplication(
        ::TemplateApplication,
        module.hot,
        BootstrapModule,
        BootstrapCssModule,
        CoreModule
    )
}
