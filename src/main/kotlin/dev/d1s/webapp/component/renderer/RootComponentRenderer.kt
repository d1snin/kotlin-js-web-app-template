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

package dev.d1s.webapp.component.renderer

import dev.d1s.webapp.component.Component
import dev.d1s.webapp.util.deploy
import io.kvision.panel.Root
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RootComponentRenderer : ComponentRenderer, KoinComponent {

    private val rootComponent by inject<Component.Root>()

    override fun render(root: Root) {
        root.deploy(rootComponent)
    }
}