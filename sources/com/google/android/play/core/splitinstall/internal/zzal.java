package com.google.android.play.core.splitinstall.internal;

import android.content.res.AssetManager;
import java.io.File;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* loaded from: classes4.dex */
public final class zzal {
    private final com.google.android.play.core.splitcompat.zza zza;
    private XmlPullParser zzb;

    public zzal(com.google.android.play.core.splitcompat.zza zzaVar) {
        this.zza = zzaVar;
    }

    public final long zza() throws IOException, XmlPullParserException {
        if (this.zzb != null) {
            while (true) {
                int next = this.zzb.next();
                if (next != 2) {
                    if (next == 1) {
                        break;
                    }
                } else if (this.zzb.getName().equals("manifest")) {
                    String attributeValue = this.zzb.getAttributeValue("http://schemas.android.com/apk/res/android", "versionCode");
                    String attributeValue2 = this.zzb.getAttributeValue("http://schemas.android.com/apk/res/android", "versionCodeMajor");
                    if (attributeValue == null) {
                        throw new XmlPullParserException("Manifest entry doesn't contain 'versionCode' attribute.");
                    }
                    try {
                        int parseInt = Integer.parseInt(attributeValue);
                        if (attributeValue2 == null) {
                            return parseInt;
                        }
                        try {
                            return (Integer.parseInt(attributeValue2) << 32) | (parseInt & 4294967295L);
                        } catch (NumberFormatException e) {
                            throw new XmlPullParserException(String.format("Couldn't parse versionCodeMajor to int: %s", e.getMessage()));
                        }
                    } catch (NumberFormatException e2) {
                        throw new XmlPullParserException(String.format("Couldn't parse versionCode to int: %s", e2.getMessage()));
                    }
                }
            }
            throw new XmlPullParserException("Couldn't find manifest entry at top-level.");
        }
        throw new XmlPullParserException("Manifest file needs to be loaded before parsing.");
    }

    public final void zzb(AssetManager assetManager, File file) throws IOException {
        this.zzb = assetManager.openXmlResourceParser(com.google.android.play.core.splitcompat.zza.zzc(assetManager, file), "AndroidManifest.xml");
    }
}
