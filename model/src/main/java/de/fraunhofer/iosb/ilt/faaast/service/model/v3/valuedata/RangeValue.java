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
package de.fraunhofer.iosb.ilt.faaast.service.model.v3.valuedata;

import io.adminshell.aas.v3.model.builder.ExtendableBuilder;
import java.util.Objects;


public class RangeValue extends DataElementValue {

    private double min;
    private double max;

    public double getMin() {
        return min;
    }


    public void setMin(double min) {
        this.min = min;
    }


    public double getMax() {
        return max;
    }


    public void setMax(double max) {
        this.max = max;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RangeValue that = (RangeValue) o;
        return Double.compare(that.min, min) == 0 && Double.compare(that.max, max) == 0;
    }


    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }


    public static Builder builder() {
        return new Builder();
    }

    public static abstract class AbstractBuilder<T extends RangeValue, B extends AbstractBuilder<T, B>> extends ExtendableBuilder<T, B> {

        public B min(double value) {
            getBuildingInstance().setMin(value);
            return getSelf();
        }


        public B max(double value) {
            getBuildingInstance().setMax(value);
            return getSelf();
        }

    }

    public static class Builder extends AbstractBuilder<RangeValue, Builder> {

        @Override
        protected Builder getSelf() {
            return this;
        }


        @Override
        protected RangeValue newBuildingInstance() {
            return new RangeValue();
        }
    }
}
