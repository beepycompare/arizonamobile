package com.facebook.widget;

import android.content.Context;
import android.os.Handler;
import androidx.loader.content.Loader;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.RequestBatch;
import com.facebook.Response;
import com.facebook.internal.CacheableRequestBatch;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
/* loaded from: classes3.dex */
class GraphObjectPagingLoader<T extends GraphObject> extends Loader<SimpleGraphObjectCursor<T>> {
    private boolean appendResults;
    private Request currentRequest;
    private SimpleGraphObjectCursor<T> cursor;
    private final Class<T> graphObjectClass;
    private boolean loading;
    private Request nextRequest;
    private OnErrorListener onErrorListener;
    private Request originalRequest;
    private boolean skipRoundtripIfCached;

    /* loaded from: classes3.dex */
    public interface OnErrorListener {
        void onError(FacebookException facebookException, GraphObjectPagingLoader<?> graphObjectPagingLoader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface PagedResults extends GraphObject {
        GraphObjectList<GraphObject> getData();
    }

    public GraphObjectPagingLoader(Context context, Class<T> cls) {
        super(context);
        this.appendResults = false;
        this.loading = false;
        this.graphObjectClass = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addResults(Response response) {
        SimpleGraphObjectCursor simpleGraphObjectCursor = (this.cursor == null || !this.appendResults) ? new SimpleGraphObjectCursor() : new SimpleGraphObjectCursor(this.cursor);
        boolean isFromCache = response.getIsFromCache();
        GraphObjectList<U> castToListOf = ((PagedResults) response.getGraphObjectAs(PagedResults.class)).getData().castToListOf((Class<T>) this.graphObjectClass);
        boolean z = castToListOf.size() > 0;
        if (z) {
            this.nextRequest = response.getRequestForPagedResults(Response.PagingDirection.NEXT);
            simpleGraphObjectCursor.addGraphObjects(castToListOf, isFromCache);
            simpleGraphObjectCursor.setMoreObjectsAvailable(true);
        }
        if (!z) {
            simpleGraphObjectCursor.setMoreObjectsAvailable(false);
            simpleGraphObjectCursor.setFromCache(isFromCache);
            this.nextRequest = null;
        }
        if (!isFromCache) {
            this.skipRoundtripIfCached = false;
        }
        deliverResult(simpleGraphObjectCursor);
    }

    private CacheableRequestBatch putRequestIntoBatch(Request request, boolean z) {
        CacheableRequestBatch cacheableRequestBatch = new CacheableRequestBatch(request);
        cacheableRequestBatch.setForceRoundTrip(!z);
        return cacheableRequestBatch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestCompleted(Response response) {
        if (response.getRequest() != this.currentRequest) {
            return;
        }
        this.loading = false;
        this.currentRequest = null;
        FacebookRequestError error = response.getError();
        FacebookException exception = error == null ? null : error.getException();
        if (response.getGraphObject() == null && exception == null) {
            exception = new FacebookException("GraphObjectPagingLoader received neither a result nor an error.");
        }
        if (exception == null) {
            addResults(response);
            return;
        }
        this.nextRequest = null;
        OnErrorListener onErrorListener = this.onErrorListener;
        if (onErrorListener != null) {
            onErrorListener.onError(exception, this);
        }
    }

    private void startLoading(Request request, boolean z, long j) {
        this.skipRoundtripIfCached = z;
        this.appendResults = false;
        this.nextRequest = null;
        this.currentRequest = request;
        request.setCallback(new Request.Callback() { // from class: com.facebook.widget.GraphObjectPagingLoader.2
            @Override // com.facebook.Request.Callback
            public void onCompleted(Response response) {
                GraphObjectPagingLoader.this.requestCompleted(response);
            }
        });
        this.loading = true;
        final CacheableRequestBatch putRequestIntoBatch = putRequestIntoBatch(request, z);
        Runnable runnable = new Runnable() { // from class: com.facebook.widget.GraphObjectPagingLoader.3
            @Override // java.lang.Runnable
            public void run() {
                Request.executeBatchAsync(putRequestIntoBatch);
            }
        };
        if (j == 0) {
            runnable.run();
        } else {
            new Handler().postDelayed(runnable, j);
        }
    }

    public void clearResults() {
        this.nextRequest = null;
        this.originalRequest = null;
        this.currentRequest = null;
        deliverResult((SimpleGraphObjectCursor) null);
    }

    public void deliverResult(SimpleGraphObjectCursor<T> simpleGraphObjectCursor) {
        SimpleGraphObjectCursor<T> simpleGraphObjectCursor2 = this.cursor;
        this.cursor = simpleGraphObjectCursor;
        if (isStarted()) {
            super.deliverResult((GraphObjectPagingLoader<T>) simpleGraphObjectCursor);
            if (simpleGraphObjectCursor2 == null || simpleGraphObjectCursor2 == simpleGraphObjectCursor || simpleGraphObjectCursor2.isClosed()) {
                return;
            }
            simpleGraphObjectCursor2.close();
        }
    }

    @Override // androidx.loader.content.Loader
    public /* bridge */ /* synthetic */ void deliverResult(Object obj) {
        deliverResult((SimpleGraphObjectCursor) ((SimpleGraphObjectCursor) obj));
    }

    public void followNextLink() {
        Request request = this.nextRequest;
        if (request != null) {
            this.appendResults = true;
            this.currentRequest = request;
            request.setCallback(new Request.Callback() { // from class: com.facebook.widget.GraphObjectPagingLoader.1
                @Override // com.facebook.Request.Callback
                public void onCompleted(Response response) {
                    GraphObjectPagingLoader.this.requestCompleted(response);
                }
            });
            this.loading = true;
            Request.executeBatchAsync((RequestBatch) putRequestIntoBatch(this.currentRequest, this.skipRoundtripIfCached));
        }
    }

    public SimpleGraphObjectCursor<T> getCursor() {
        return this.cursor;
    }

    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public boolean isLoading() {
        return this.loading;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.loader.content.Loader
    public void onStartLoading() {
        super.onStartLoading();
        SimpleGraphObjectCursor<T> simpleGraphObjectCursor = this.cursor;
        if (simpleGraphObjectCursor != null) {
            deliverResult((SimpleGraphObjectCursor) simpleGraphObjectCursor);
        }
    }

    public void refreshOriginalRequest(long j) {
        Request request = this.originalRequest;
        if (request == null) {
            throw new FacebookException("refreshOriginalRequest may not be called until after startLoading has been called.");
        }
        startLoading(request, false, j);
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public void startLoading(Request request, boolean z) {
        this.originalRequest = request;
        startLoading(request, z, 0L);
    }
}
