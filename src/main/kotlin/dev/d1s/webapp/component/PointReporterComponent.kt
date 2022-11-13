package dev.d1s.webapp.component

import io.kvision.core.*
import io.kvision.html.div
import io.kvision.panel.vPanel
import io.kvision.state.ObservableValue
import io.kvision.state.bind
import io.kvision.utils.em
import io.kvision.utils.perc
import kotlinx.browser.document

private data class Point(
    val x: Double = .0,
    val y: Double = .0
)

fun Container.pointReporter() {
    val observablePoint = ObservableValue(Point())

    vPanel {
        justifyContent = JustifyContent.CENTER
        alignItems = AlignItems.CENTER

        height = 100.perc
        color = Color.name(Col.WHITE)
        fontFamily = "JetBrains Mono"
        fontSize = 5.em

        div().bind(observablePoint) { state ->
            +state.toString()
        }
    }

    document.onmousemove = {
        observablePoint.value = Point(it.x, it.y)
        asDynamic()
    }
}