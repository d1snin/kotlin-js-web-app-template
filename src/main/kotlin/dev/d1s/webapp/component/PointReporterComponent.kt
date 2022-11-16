/*
 * Copyright 2022 Mikhail Titov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.d1s.webapp.component

import io.kvision.core.*
import io.kvision.html.div
import io.kvision.panel.vPanel
import io.kvision.state.ObservableValue
import io.kvision.state.bind
import io.kvision.utils.perc
import io.kvision.utils.vw
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
        fontSize = 7.vw

        div().bind(observablePoint) { state ->
            +state.toString()
        }
    }

    document.onmousemove = {
        observablePoint.value = Point(it.x, it.y)
        asDynamic()
    }
}