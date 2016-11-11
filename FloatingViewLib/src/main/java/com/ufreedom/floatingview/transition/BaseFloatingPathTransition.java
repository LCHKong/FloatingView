/*
 * Copyright (C) 2015 UFreedom
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


package com.ufreedom.floatingview.transition;

/**
 * Author UFreedom
 * Date : 2016 十月 19
 */

public abstract  class BaseFloatingPathTransition  implements FloatingPathTransition {

    private PathPosition pathPosition;
    private float [] pathPositionGetter;
    
    public float getStartPathPosition(){
        return 0;
    }
    
    public float getEndPathPosition(){
        if (getFloatingPath() != null){
            return getFloatingPath().getPathMeasure().getLength();
        }
        return 0;
    }
    
    public PathPosition getFloatingPosition(float progress) {
        if (pathPosition == null){
            pathPosition = new PathPosition();
        }
        if (pathPositionGetter == null){
            pathPositionGetter = new float[2];
        }
        if (getFloatingPath() != null){
            getFloatingPath() .getPathMeasure().getPosTan(progress, pathPositionGetter, null);
            pathPosition.x = pathPositionGetter[0];
            pathPosition.y = pathPositionGetter[1];
        }
        return pathPosition;
    }
    
    
    
}
