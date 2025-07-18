package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.conn.ConnectTimeoutException;
/* loaded from: classes3.dex */
class AdaptedHttpStack extends BaseHttpStack {
    private final HttpStack mHttpStack;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdaptedHttpStack(HttpStack httpStack) {
        this.mHttpStack = httpStack;
    }

    @Override // com.android.volley.toolbox.BaseHttpStack
    public HttpResponse executeRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        try {
            org.apache.http.HttpResponse performRequest = this.mHttpStack.performRequest(request, map);
            int statusCode = performRequest.getStatusLine().getStatusCode();
            Header[] allHeaders = performRequest.getAllHeaders();
            ArrayList arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new com.android.volley.Header(header.getName(), header.getValue()));
            }
            if (performRequest.getEntity() == null) {
                return new HttpResponse(statusCode, arrayList);
            }
            long contentLength = performRequest.getEntity().getContentLength();
            if (((int) contentLength) != contentLength) {
                throw new IOException("Response too large: " + contentLength);
            }
            return new HttpResponse(statusCode, arrayList, (int) performRequest.getEntity().getContentLength(), performRequest.getEntity().getContent());
        } catch (ConnectTimeoutException e) {
            throw new SocketTimeoutException(e.getMessage());
        }
    }
}
