/*
 * Copyright 2022-2023 Mikhail Titov
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

import dev.d1s.webapp.di.Qualifier
import dev.d1s.webapp.util.deploy
import io.kvision.core.Background
import io.kvision.core.Col
import io.kvision.core.Color
import io.kvision.html.div
import io.kvision.panel.SimplePanel
import io.kvision.utils.vh
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RootComponent : Component.Root, KoinComponent {

    private val pointReporterComponent by inject<Component>(Qualifier.PointReporterComponent)

    override fun SimplePanel.render() {
        minHeight = 100.vh

        background = Background(Color.name(Col.BLACK))

        div(className = "container-fluid justify-content-center align-items-center") {
            minHeight = 100.vh

            deploy(pointReporterComponent)
        }
    }
}