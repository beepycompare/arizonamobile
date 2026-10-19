package com.miami.game.core.settings.mods;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriPermission;
import android.net.Uri;
import com.miami.game.core.settings.SettingsMenuDefaults;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ModsPreferences.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/miami/game/core/settings/mods/ModsPreferences;", "", "<init>", "()V", "ENABLED", "", "hotReloadCapable", "", "context", "Landroid/content/Context;", "SOURCE", "prefs", "Landroid/content/SharedPreferences;", "setEnabled", "", "enabled", "selectFolder", "uri", "Landroid/net/Uri;", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModsPreferences {
    public static final String ENABLED = "modsEnabled";
    public static final ModsPreferences INSTANCE = new ModsPreferences();
    public static final String SOURCE = "modsSourceUri";

    private ModsPreferences() {
    }

    public final boolean hotReloadCapable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int identifier = context.getResources().getIdentifier("resource_hot_reload_capable", "bool", context.getPackageName());
        return identifier != 0 && context.getResources().getBoolean(identifier);
    }

    public final SharedPreferences prefs(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SettingsMenuDefaults.prefs(context);
    }

    public final void setEnabled(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (ModsStorage.INSTANCE.getLock$settings()) {
            if (z) {
                String string = INSTANCE.prefs(context).getString(SOURCE, null);
                if (string != null) {
                    Uri parse = Uri.parse(string);
                    Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                    ModsDocuments.createStarterIfEmpty$default(new ModsDocuments(context, parse), null, 1, null);
                }
            }
            if (!INSTANCE.prefs(context).edit().putBoolean(ENABLED, z).commit()) {
                throw new IllegalStateException("Cannot save mod settings".toString());
            }
            if (!z) {
                ModsStorage.INSTANCE.clearImportedCopies(context);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void selectFolder(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (ModsStorage.INSTANCE.getLock$settings()) {
            SharedPreferences prefs = INSTANCE.prefs(context);
            if (uri != null) {
                context.getContentResolver().takePersistableUriPermission(uri, 3);
            }
            Object obj = null;
            String string = prefs.getString(SOURCE, null);
            if (!prefs.edit().putString(SOURCE, uri != null ? uri.toString() : null).commit()) {
                throw new IllegalStateException("Check failed.");
            }
            if (string != null) {
                if (!Intrinsics.areEqual(string, uri != null ? uri.toString() : null)) {
                    Result.Companion companion = Result.Companion;
                    List<UriPermission> persistedUriPermissions = context.getContentResolver().getPersistedUriPermissions();
                    Intrinsics.checkNotNullExpressionValue(persistedUriPermissions, "getPersistedUriPermissions(...)");
                    Iterator<T> it = persistedUriPermissions.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (Intrinsics.areEqual(((UriPermission) next).getUri().toString(), string)) {
                            obj = next;
                            break;
                        }
                    }
                    UriPermission uriPermission = (UriPermission) obj;
                    int i = 0;
                    int i2 = (uriPermission == null || !uriPermission.isReadPermission()) ? 0 : 1;
                    if (uriPermission != null && uriPermission.isWritePermission()) {
                        i = 2;
                    }
                    int i3 = i2 | i;
                    if (i3 != 0) {
                        context.getContentResolver().releasePersistableUriPermission(Uri.parse(string), i3);
                    }
                    Result.m9974constructorimpl(Unit.INSTANCE);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
