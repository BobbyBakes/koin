/*
 * Copyright 2017-2021 the original author or authors.
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

package org.koin.androidx.scope

import androidx.lifecycle.LifecycleOwner
import org.koin.androidx.scope.observer.LifecycleOnDestroyCloser
import org.koin.androidx.scope.observer.LifecycleOnStopCloser
import org.koin.core.scope.Scope

@Deprecated("Use ScopeActivity or ScopeFragment instead", replaceWith = ReplaceWith("lifecycleScope"),
        level = DeprecationLevel.ERROR)
val LifecycleOwner.lifecycleScope: Scope
    get() = error("Don't use scope on a lifecycle component. Use ScopeActivity or ScopeFragment instead")

@Deprecated("Use ScopeActivity or ScopeFragment instead", replaceWith = ReplaceWith("lifecycleScope"),
        level = DeprecationLevel.ERROR)
val LifecycleOwner.scope: Scope
    get() = error("Don't use scope on a lifecycle component. Use ScopeActivity or ScopeFragment instead")

@Deprecated("Use ScopeActivity or ScopeFragment instead", replaceWith = ReplaceWith("lifecycleScope"),
        level = DeprecationLevel.ERROR)
val LifecycleOwner.currentScope: Scope
    get() = error("Don't use scope on a lifecycle component. Use ScopeActivity or ScopeFragment instead")


fun Scope.closeOnStop(owner: LifecycleOwner) {
    owner.lifecycle.addObserver(LifecycleOnStopCloser(this))
}

fun Scope.closeOnDestroy(owner: LifecycleOwner) {
    owner.lifecycle.addObserver(LifecycleOnDestroyCloser(this))
}