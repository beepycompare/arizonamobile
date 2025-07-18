package com.facebook.widget;

import com.facebook.model.GraphObject;
/* loaded from: classes3.dex */
interface GraphObjectCursor<T extends GraphObject> {
    boolean areMoreObjectsAvailable();

    void close();

    int getCount();

    T getGraphObject();

    int getPosition();

    boolean isAfterLast();

    boolean isBeforeFirst();

    boolean isClosed();

    boolean isFirst();

    boolean isFromCache();

    boolean isLast();

    boolean move(int i);

    boolean moveToFirst();

    boolean moveToLast();

    boolean moveToNext();

    boolean moveToPosition(int i);

    boolean moveToPrevious();
}
