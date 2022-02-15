/*
 * Copyright (c) 2021 Fraunhofer IOSB, eine rechtlich nicht selbstaendige
 * Einrichtung der Fraunhofer-Gesellschaft zur Foerderung der angewandten
 * Forschung e.V.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.fraunhofer.iosb.ilt.faaast.service.typing;

public class ContainerTypeInfo<T> extends TypeInfo<T> {

    private Class<?> contentType;

    public static <T> Builder<T> builder() {
        return new Builder();
    }

    public static abstract class AbstractBuilder<P, T extends ContainerTypeInfo<P>, B extends AbstractBuilder<P, T, B>> extends TypeInfo.AbstractBuilder<P, T, B> {

        public B contentType(Class<?> value) {
            getBuildingInstance().setContentType(value);
            return getSelf();
        }

    }

    public static class Builder<T> extends AbstractBuilder<T, ContainerTypeInfo<T>, Builder<T>> {

        @Override
        protected Builder getSelf() {
            return this;
        }


        @Override
        protected ContainerTypeInfo<T> newBuildingInstance() {
            return new ContainerTypeInfo();
        }
    }

    public Class<?> getContentType() {
        return contentType;
    }


    public void setContentType(Class<?> contentType) {
        this.contentType = contentType;
    }

}
