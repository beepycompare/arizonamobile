package ru.mrlargha.commonui.elements;

import android.app.Activity;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: InputStorage.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000bJ\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\rJ\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\tJ\u0006\u0010\u001f\u001a\u00020\rJ\u000e\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\rJ\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011j\b\u0012\u0004\u0012\u00020\t`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006%"}, d2 = {"Lru/mrlargha/commonui/elements/InputStorage;", "", "transferActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "activity", "buttonString", "", "", "buttonState", "", "maxBinder", "", "maxHistory", "historyFilePath", "arrayHistory", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setBinderState", "", "index_binder", RemoteConfigConstants.ResponseFieldKey.STATE, "getIndexState", "setBinderName", "name", "getBinderName", "isEmptyButtons", "()Z", "AddKeyboardHistory", "str", "GetKeyboardHistorySize", "GetKeyboardHistoryText", FirebaseAnalytics.Param.INDEX, "writeHistory", "loadHistory", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InputStorage {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "InputStorage";
    private final Activity activity;
    private final ArrayList<String> arrayHistory;
    private final List<Boolean> buttonState;
    private final List<String> buttonString;
    private final String historyFilePath;
    private final int maxBinder;
    private final int maxHistory;

    public InputStorage(Activity transferActivity) {
        Intrinsics.checkNotNullParameter(transferActivity, "transferActivity");
        this.activity = transferActivity;
        this.maxBinder = 30;
        this.maxHistory = 20;
        this.historyFilePath = transferActivity.getFilesDir().getPath() + "/chat_history.dat";
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.ensureCapacity(20);
        this.arrayHistory = arrayList;
        this.buttonString = new ArrayList();
        this.buttonState = new ArrayList();
        int i = 0;
        while (i < 30) {
            i++;
            ((ArrayList) this.buttonString).add("Бинд №" + i);
            ((ArrayList) this.buttonState).add(false);
        }
        loadHistory();
    }

    public final void setBinderState(int i, boolean z) {
        this.buttonState.set(i, Boolean.valueOf(z));
    }

    public final boolean getIndexState(int i) {
        return this.buttonState.get(i).booleanValue();
    }

    public final void setBinderName(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Log.d("MrLargha", "Installing new binder name: " + ((Object) this.buttonString.get(i)));
        this.buttonString.set(i, name);
    }

    public final String getBinderName(int i) {
        return this.buttonString.get(i);
    }

    public final boolean isEmptyButtons() {
        int i = this.maxBinder;
        for (int i2 = 0; i2 < i; i2++) {
            if (getIndexState(i2)) {
                return false;
            }
        }
        return true;
    }

    public final void AddKeyboardHistory(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (this.arrayHistory.size() >= this.maxHistory) {
            ArrayList<String> arrayList = this.arrayHistory;
            arrayList.remove(arrayList.size() - 1);
        }
        this.arrayHistory.add(0, str);
        writeHistory();
    }

    public final int GetKeyboardHistorySize() {
        return this.arrayHistory.size();
    }

    public final String GetKeyboardHistoryText(int i) {
        try {
            String str = this.arrayHistory.get(i);
            Intrinsics.checkNotNull(str);
            return str;
        } catch (ArrayIndexOutOfBoundsException unused) {
            return "";
        }
    }

    private final void writeHistory() {
        try {
            new File(this.historyFilePath).createNewFile();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.historyFilePath));
            ObjectOutputStream objectOutputStream2 = objectOutputStream;
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.arrayHistory) {
                String str = (String) obj;
                if (!StringsKt.startsWith$default(str, "/passwd", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "/q", false, 2, (Object) null)) {
                    arrayList.add(obj);
                }
            }
            objectOutputStream2.writeObject(arrayList);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(objectOutputStream, null);
        } catch (Exception unused) {
            Log.w(TAG, "Can not write or create history file");
        }
    }

    private final void loadHistory() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.historyFilePath));
            try {
                Object readObject = objectInputStream.readObject();
                Intrinsics.checkNotNull(readObject, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
                ArrayList<String> arrayList = (ArrayList) readObject;
                if (arrayList.size() <= this.maxHistory) {
                    for (String str : arrayList) {
                        this.arrayHistory.add(str);
                    }
                }
            } catch (ClassCastException unused) {
                Log.w(TAG, "Damaged history file");
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(objectInputStream, null);
        } catch (Exception e) {
            Log.w(TAG, "Can't open or read history file: " + e + " " + e.getMessage());
        }
    }

    /* compiled from: InputStorage.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/mrlargha/commonui/elements/InputStorage$Companion;", "", "<init>", "()V", "TAG", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
