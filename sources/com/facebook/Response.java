package com.facebook;

import android.content.Context;
import com.facebook.internal.CacheableRequestBatch;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import com.google.android.material.timepicker.TimeModel;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes3.dex */
public class Response {
    static final /* synthetic */ boolean $assertionsDisabled = true;
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    private static final int INVALID_SESSION_FACEBOOK_ERROR_CODE = 190;
    public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
    private static final String RESPONSE_CACHE_TAG = "ResponseCache";
    private static final String RESPONSE_LOG_TAG = "Response";
    private static FileLruCache responseCache;
    private final HttpURLConnection connection;
    private final FacebookRequestError error;
    private final GraphObject graphObject;
    private final GraphObjectList<GraphObject> graphObjectList;
    private final boolean isFromCache;
    private final Request request;

    /* loaded from: classes3.dex */
    interface PagedResults extends GraphObject {
        GraphObjectList<GraphObject> getData();

        PagingInfo getPaging();
    }

    /* loaded from: classes3.dex */
    public enum PagingDirection {
        NEXT,
        PREVIOUS;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PagingDirection[] valuesCustom() {
            PagingDirection[] valuesCustom = values();
            int length = valuesCustom.length;
            PagingDirection[] pagingDirectionArr = new PagingDirection[length];
            System.arraycopy(valuesCustom, 0, pagingDirectionArr, 0, length);
            return pagingDirectionArr;
        }
    }

    /* loaded from: classes3.dex */
    interface PagingInfo extends GraphObject {
        String getNext();

        String getPrevious();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Response(Request request, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this.request = request;
        this.connection = httpURLConnection;
        this.graphObject = null;
        this.graphObjectList = null;
        this.isFromCache = false;
        this.error = facebookRequestError;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Response(Request request, HttpURLConnection httpURLConnection, GraphObject graphObject, boolean z) {
        this.request = request;
        this.connection = httpURLConnection;
        this.graphObject = graphObject;
        this.graphObjectList = null;
        this.isFromCache = z;
        this.error = null;
    }

    Response(Request request, HttpURLConnection httpURLConnection, GraphObjectList<GraphObject> graphObjectList, boolean z) {
        this.request = request;
        this.connection = httpURLConnection;
        this.graphObject = null;
        this.graphObjectList = graphObjectList;
        this.isFromCache = z;
        this.error = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Response> constructErrorResponses(List<Request> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new Response(list.get(i), httpURLConnection, new FacebookRequestError(httpURLConnection, facebookException)));
        }
        return arrayList;
    }

    private static Response createResponseFromObject(Request request, HttpURLConnection httpURLConnection, Object obj, boolean z, Object obj2) throws JSONException {
        Session session;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            FacebookRequestError checkResponseAndCreateError = FacebookRequestError.checkResponseAndCreateError(jSONObject, obj2, httpURLConnection);
            if (checkResponseAndCreateError != null) {
                if (checkResponseAndCreateError.getErrorCode() == 190 && (session = request.getSession()) != null) {
                    session.closeAndClearTokenInformation();
                }
                return new Response(request, httpURLConnection, checkResponseAndCreateError);
            }
            Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, "body", NON_JSON_RESPONSE_PROPERTY);
            if (stringPropertyAsJSON instanceof JSONObject) {
                return new Response(request, httpURLConnection, GraphObject.Factory.create((JSONObject) stringPropertyAsJSON), z);
            }
            if (stringPropertyAsJSON instanceof JSONArray) {
                return new Response(request, httpURLConnection, GraphObject.Factory.createList((JSONArray) stringPropertyAsJSON, GraphObject.class), z);
            }
            obj = JSONObject.NULL;
        }
        if (obj == JSONObject.NULL) {
            return new Response(request, httpURLConnection, (GraphObject) null, z);
        }
        throw new FacebookException("Got unexpected object type in response, class: " + obj.getClass().getSimpleName());
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<Response> createResponsesFromObject(HttpURLConnection httpURLConnection, List<Request> list, Object obj, boolean z) throws FacebookException, JSONException {
        JSONArray jSONArray;
        Response response;
        Response response2;
        if ($assertionsDisabled || httpURLConnection != null || z) {
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            if (size == 1) {
                Request request = list.get(0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("body", obj);
                    jSONObject.put(CODE_KEY, httpURLConnection != null ? httpURLConnection.getResponseCode() : 200);
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(jSONObject);
                    jSONArray = jSONArray2;
                } catch (IOException e) {
                    response2 = new Response(request, httpURLConnection, new FacebookRequestError(httpURLConnection, e));
                    arrayList.add(response2);
                    jSONArray = obj;
                    if (jSONArray instanceof JSONArray) {
                    }
                    throw new FacebookException("Unexpected number of results");
                } catch (JSONException e2) {
                    response2 = new Response(request, httpURLConnection, new FacebookRequestError(httpURLConnection, e2));
                    arrayList.add(response2);
                    jSONArray = obj;
                    if (jSONArray instanceof JSONArray) {
                    }
                    throw new FacebookException("Unexpected number of results");
                }
                if (jSONArray instanceof JSONArray) {
                    JSONArray jSONArray3 = (JSONArray) jSONArray;
                    if (jSONArray3.length() == size) {
                        for (int i = 0; i < jSONArray3.length(); i++) {
                            Request request2 = list.get(i);
                            try {
                                arrayList.add(createResponseFromObject(request2, httpURLConnection, jSONArray3.get(i), z, obj));
                            } catch (FacebookException e3) {
                                response = new Response(request2, httpURLConnection, new FacebookRequestError(httpURLConnection, e3));
                                arrayList.add(response);
                            } catch (JSONException e4) {
                                response = new Response(request2, httpURLConnection, new FacebookRequestError(httpURLConnection, e4));
                                arrayList.add(response);
                            }
                        }
                        return arrayList;
                    }
                }
                throw new FacebookException("Unexpected number of results");
            }
            jSONArray = obj;
            if (jSONArray instanceof JSONArray) {
            }
            throw new FacebookException("Unexpected number of results");
        }
        throw new AssertionError();
    }

    static List<Response> createResponsesFromStream(InputStream inputStream, HttpURLConnection httpURLConnection, RequestBatch requestBatch, boolean z) throws FacebookException, JSONException, IOException {
        String readStreamToString = Utility.readStreamToString(inputStream);
        Logger.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, RESPONSE_LOG_TAG, "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(readStreamToString.length()), readStreamToString);
        return createResponsesFromString(readStreamToString, httpURLConnection, requestBatch, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Response> createResponsesFromString(String str, HttpURLConnection httpURLConnection, RequestBatch requestBatch, boolean z) throws FacebookException, JSONException, IOException {
        List<Response> createResponsesFromObject = createResponsesFromObject(httpURLConnection, requestBatch, new JSONTokener(str).nextValue(), z);
        Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", requestBatch.getId(), Integer.valueOf(str.length()), createResponsesFromObject);
        return createResponsesFromObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006d A[Catch: all -> 0x008c, SecurityException -> 0x008e, IOException -> 0x00a5, JSONException -> 0x00bc, FacebookException -> 0x00d3, Merged into TryCatch #7 {all -> 0x008c, FacebookException -> 0x00d3, IOException -> 0x00a5, SecurityException -> 0x008e, JSONException -> 0x00bc, blocks: (B:29:0x0065, B:31:0x006d, B:40:0x0084, B:33:0x0073, B:37:0x007d, B:46:0x008f, B:50:0x00a6, B:54:0x00bd, B:58:0x00d4), top: B:64:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0073 A[Catch: all -> 0x008c, SecurityException -> 0x008e, IOException -> 0x00a5, JSONException -> 0x00bc, FacebookException -> 0x00d3, Merged into TryCatch #7 {all -> 0x008c, FacebookException -> 0x00d3, IOException -> 0x00a5, SecurityException -> 0x008e, JSONException -> 0x00bc, blocks: (B:29:0x0065, B:31:0x006d, B:40:0x0084, B:33:0x0073, B:37:0x007d, B:46:0x008f, B:50:0x00a6, B:54:0x00bd, B:58:0x00d4), top: B:64:0x0065 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<Response> fromHttpConnection(HttpURLConnection httpURLConnection, RequestBatch requestBatch) {
        FileLruCache fileLruCache;
        String str;
        InputStream interceptAndPut;
        InputStream inputStream = null;
        if (requestBatch instanceof CacheableRequestBatch) {
            CacheableRequestBatch cacheableRequestBatch = (CacheableRequestBatch) requestBatch;
            fileLruCache = getResponseCache();
            str = cacheableRequestBatch.getCacheKeyOverride();
            if (Utility.isNullOrEmpty(str)) {
                if (requestBatch.size() == 1) {
                    str = requestBatch.get(0).getUrlForSingleRequest();
                } else {
                    Logger.log(LoggingBehavior.REQUESTS, RESPONSE_CACHE_TAG, "Not using cache for cacheable request because no key was specified");
                }
            }
            if (!cacheableRequestBatch.getForceRoundTrip() && fileLruCache != null && !Utility.isNullOrEmpty(str)) {
                try {
                    InputStream inputStream2 = fileLruCache.get(str);
                    if (inputStream2 != null) {
                        try {
                            List<Response> createResponsesFromStream = createResponsesFromStream(inputStream2, null, requestBatch, true);
                            Utility.closeQuietly(inputStream2);
                            return createResponsesFromStream;
                        } catch (FacebookException | IOException | JSONException unused) {
                            inputStream = inputStream2;
                            Utility.closeQuietly(inputStream);
                            if (httpURLConnection.getResponseCode() >= 400) {
                            }
                            inputStream = interceptAndPut;
                            return createResponsesFromStream(inputStream, httpURLConnection, requestBatch, false);
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            throw th;
                        }
                    }
                    Utility.closeQuietly(inputStream2);
                    inputStream = inputStream2;
                } catch (FacebookException | IOException | JSONException unused2) {
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } else {
            fileLruCache = null;
            str = null;
        }
        try {
            if (httpURLConnection.getResponseCode() >= 400) {
                inputStream = httpURLConnection.getInputStream();
                if (fileLruCache != null && str != null && inputStream != null && (interceptAndPut = fileLruCache.interceptAndPut(str, inputStream)) != null) {
                }
                return createResponsesFromStream(inputStream, httpURLConnection, requestBatch, false);
            }
            interceptAndPut = httpURLConnection.getErrorStream();
            inputStream = interceptAndPut;
            return createResponsesFromStream(inputStream, httpURLConnection, requestBatch, false);
        } catch (FacebookException e) {
            Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response <Error>: %s", e);
            return constructErrorResponses(requestBatch, httpURLConnection, e);
        } catch (IOException e2) {
            Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response <Error>: %s", e2);
            return constructErrorResponses(requestBatch, httpURLConnection, new FacebookException(e2));
        } catch (SecurityException e3) {
            Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response <Error>: %s", e3);
            return constructErrorResponses(requestBatch, httpURLConnection, new FacebookException(e3));
        } catch (JSONException e4) {
            Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response <Error>: %s", e4);
            return constructErrorResponses(requestBatch, httpURLConnection, new FacebookException(e4));
        } finally {
            Utility.closeQuietly(inputStream);
        }
    }

    static FileLruCache getResponseCache() {
        Context staticContext;
        if (responseCache == null && (staticContext = Session.getStaticContext()) != null) {
            responseCache = new FileLruCache(staticContext, RESPONSE_CACHE_TAG, new FileLruCache.Limits());
        }
        return responseCache;
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final FacebookRequestError getError() {
        return this.error;
    }

    public final GraphObject getGraphObject() {
        return this.graphObject;
    }

    public final <T extends GraphObject> T getGraphObjectAs(Class<T> cls) {
        GraphObject graphObject = this.graphObject;
        if (graphObject == null) {
            return null;
        }
        if (cls != null) {
            return (T) graphObject.cast(cls);
        }
        throw new NullPointerException("Must pass in a valid interface that extends GraphObject");
    }

    public final GraphObjectList<GraphObject> getGraphObjectList() {
        return this.graphObjectList;
    }

    public final <T extends GraphObject> GraphObjectList<T> getGraphObjectListAs(Class<T> cls) {
        GraphObjectList<GraphObject> graphObjectList = this.graphObjectList;
        if (graphObjectList == null) {
            return null;
        }
        return (GraphObjectList<T>) graphObjectList.castToListOf(cls);
    }

    public final boolean getIsFromCache() {
        return this.isFromCache;
    }

    public Request getRequest() {
        return this.request;
    }

    public Request getRequestForPagedResults(PagingDirection pagingDirection) {
        PagingInfo paging;
        GraphObject graphObject = this.graphObject;
        String next = (graphObject == null || (paging = ((PagedResults) graphObject.cast(PagedResults.class)).getPaging()) == null) ? null : pagingDirection == PagingDirection.NEXT ? paging.getNext() : paging.getPrevious();
        if (Utility.isNullOrEmpty(next)) {
            return null;
        }
        if (next == null || !next.equals(this.request.getUrlForSingleRequest())) {
            try {
                return new Request(this.request.getSession(), new URL(next));
            } catch (MalformedURLException unused) {
                return null;
            }
        }
        return null;
    }

    public String toString() {
        String str;
        try {
            HttpURLConnection httpURLConnection = this.connection;
            str = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(httpURLConnection != null ? httpURLConnection.getResponseCode() : 200));
        } catch (IOException unused) {
            str = "unknown";
        }
        return "{Response:  responseCode: " + str + ", graphObject: " + this.graphObject + ", error: " + this.error + ", isFromCache:" + this.isFromCache + "}";
    }
}
