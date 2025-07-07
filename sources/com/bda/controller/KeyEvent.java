package com.bda.controller;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class KeyEvent extends BaseEvent implements Parcelable {
    public static final int ACTION_DOWN = 0;
    public static final int ACTION_UP = 1;
    public static final Parcelable.Creator<KeyEvent> CREATOR = new ParcelableCreator();
    public static final int KEYCODE_BUTTON_A = 96;
    public static final int KEYCODE_BUTTON_B = 97;
    public static final int KEYCODE_BUTTON_L1 = 102;
    public static final int KEYCODE_BUTTON_L2 = 104;
    public static final int KEYCODE_BUTTON_R1 = 103;
    public static final int KEYCODE_BUTTON_R2 = 105;
    public static final int KEYCODE_BUTTON_SELECT = 109;
    public static final int KEYCODE_BUTTON_START = 108;
    public static final int KEYCODE_BUTTON_THUMBL = 106;
    public static final int KEYCODE_BUTTON_THUMBR = 107;
    public static final int KEYCODE_BUTTON_X = 99;
    public static final int KEYCODE_BUTTON_Y = 100;
    public static final int KEYCODE_DPAD_DOWN = 20;
    public static final int KEYCODE_DPAD_LEFT = 21;
    public static final int KEYCODE_DPAD_RIGHT = 22;
    public static final int KEYCODE_DPAD_UP = 19;
    public static final int KEYCODE_UNKNOWN = 0;
    final int mAction;
    final int mKeyCode;

    /* loaded from: classes3.dex */
    static class ParcelableCreator implements Parcelable.Creator<KeyEvent> {
        ParcelableCreator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KeyEvent createFromParcel(Parcel parcel) {
            return new KeyEvent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KeyEvent[] newArray(int i) {
            return new KeyEvent[i];
        }
    }

    public KeyEvent(long j, int i, int i2, int i3) {
        super(j, i);
        this.mKeyCode = i2;
        this.mAction = i3;
    }

    KeyEvent(Parcel parcel) {
        super(parcel);
        this.mKeyCode = parcel.readInt();
        this.mAction = parcel.readInt();
    }

    @Override // com.bda.controller.BaseEvent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getAction() {
        return this.mAction;
    }

    public final int getKeyCode() {
        return this.mKeyCode;
    }

    @Override // com.bda.controller.BaseEvent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mKeyCode);
        parcel.writeInt(this.mAction);
    }
}
