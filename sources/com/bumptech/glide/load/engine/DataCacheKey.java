package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes3.dex */
final class DataCacheKey implements Key {
    private final Key signature;
    private final Key sourceKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheKey(Key key, Key key2) {
        this.sourceKey = key;
        this.signature = key2;
    }

    Key getSourceKey() {
        return this.sourceKey;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DataCacheKey) {
            DataCacheKey dataCacheKey = (DataCacheKey) obj;
            if (this.sourceKey.equals(dataCacheKey.sourceKey) && this.signature.equals(dataCacheKey.signature)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.sourceKey.hashCode() * 31) + this.signature.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.sourceKey + ", signature=" + this.signature + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.sourceKey.updateDiskCacheKey(messageDigest);
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
