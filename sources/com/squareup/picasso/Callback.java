package com.squareup.picasso;
/* loaded from: classes4.dex */
public interface Callback {

    /* loaded from: classes4.dex */
    public static class EmptyCallback implements Callback {
        @Override // com.squareup.picasso.Callback
        public void onError(Exception exc) {
        }

        @Override // com.squareup.picasso.Callback
        public void onSuccess() {
        }
    }

    void onError(Exception exc);

    void onSuccess();
}
