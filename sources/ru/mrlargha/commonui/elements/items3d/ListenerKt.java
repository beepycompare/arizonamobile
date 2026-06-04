package ru.mrlargha.commonui.elements.items3d;

import android.app.Activity;
import android.util.DisplayMetrics;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: listener.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0004H\u0002\u001a\"\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\r\u001a\u00020\u0004H\u0002\u001a\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001\u001a\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u001e\u0010$\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001\"\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"deg", "", "v", "quatAxisAngle", "Lru/mrlargha/commonui/elements/items3d/Quat;", "ax", "ay", "az", "degAngle", "mul", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "normalize", "q", "toMat3", "", "eulerZXYFromQuat", "Lkotlin/Triple;", "resetWithBase", "", "baseX", "baseY", "baseZ", "positionModelCentered", "Lru/mrlargha/commonui/elements/items3d/Position;", "activity", "Landroid/app/Activity;", "percentHeight", "yawDeg", "pitchDeg", "PITCH_MIN", "PITCH_MAX", "DOMINANT_BIAS", "CAM_UP", "CAM_RIGHT", "qBase", "resetWithBaseTurntable", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ListenerKt {
    private static final float DOMINANT_BIAS = 1.35f;
    private static final float PITCH_MAX = 85.0f;
    private static final float PITCH_MIN = -85.0f;
    private static float pitchDeg;
    private static float yawDeg;
    private static Quat q = new Quat(1.0f, 0.0f, 0.0f, 0.0f);
    private static final float[] CAM_UP = {0.0f, 0.0f, 1.0f};
    private static final float[] CAM_RIGHT = {1.0f, 0.0f, 0.0f};
    private static Quat qBase = new Quat(1.0f, 0.0f, 0.0f, 0.0f);

    private static final float eulerZXYFromQuat$rad2deg(float f) {
        return (f * 180.0f) / 3.1415927f;
    }

    private static final float deg(float f) {
        return (float) Math.toRadians(f);
    }

    private static final Quat quatAxisAngle(float f, float f2, float f3, float f4) {
        double deg = deg(f4) / 2.0f;
        float sin = (float) Math.sin(deg);
        return new Quat((float) Math.cos(deg), f * sin, f2 * sin, f3 * sin);
    }

    private static final Quat mul(Quat quat, Quat quat2) {
        return new Quat((((quat.getW() * quat2.getW()) - (quat.getX() * quat2.getX())) - (quat.getY() * quat2.getY())) - (quat.getZ() * quat2.getZ()), (((quat.getW() * quat2.getX()) + (quat.getX() * quat2.getW())) + (quat.getY() * quat2.getZ())) - (quat.getZ() * quat2.getY()), ((quat.getW() * quat2.getY()) - (quat.getX() * quat2.getZ())) + (quat.getY() * quat2.getW()) + (quat.getZ() * quat2.getX()), (((quat.getW() * quat2.getZ()) + (quat.getX() * quat2.getY())) - (quat.getY() * quat2.getX())) + (quat.getZ() * quat2.getW()));
    }

    private static final Quat normalize(Quat quat) {
        float sqrt = (float) Math.sqrt((quat.getW() * quat.getW()) + (quat.getX() * quat.getX()) + (quat.getY() * quat.getY()) + (quat.getZ() * quat.getZ()));
        return new Quat(quat.getW() / sqrt, quat.getX() / sqrt, quat.getY() / sqrt, quat.getZ() / sqrt);
    }

    private static final float[] toMat3(Quat quat) {
        float w = quat.getW();
        float x = quat.getX();
        float y = quat.getY();
        float z = quat.getZ();
        float f = x * x;
        float f2 = y * y;
        float f3 = z * z;
        float f4 = w * x;
        float f5 = w * y;
        float f6 = w * z;
        float f7 = x * y;
        float f8 = x * z;
        float f9 = y * z;
        return new float[]{1.0f - ((f2 + f3) * 2.0f), (f7 - f6) * 2.0f, (f8 + f5) * 2.0f, (f7 + f6) * 2.0f, 1.0f - ((f3 + f) * 2.0f), (f9 - f4) * 2.0f, (f8 - f5) * 2.0f, (f9 + f4) * 2.0f, 1.0f - ((f + f2) * 2.0f)};
    }

    private static final Triple<Float, Float, Float> eulerZXYFromQuat(Quat quat) {
        float[] mat3 = toMat3(normalize(quat));
        return new Triple<>(Float.valueOf(eulerZXYFromQuat$rad2deg((float) Math.asin(mat3[7]))), Float.valueOf(eulerZXYFromQuat$rad2deg((float) Math.atan2(-mat3[6], mat3[8]))), Float.valueOf(eulerZXYFromQuat$rad2deg((float) Math.atan2(-mat3[1], mat3[4]))));
    }

    public static final void resetWithBase(float f, float f2, float f3) {
        q = normalize(mul(mul(quatAxisAngle(0.0f, 0.0f, 1.0f, f3), quatAxisAngle(1.0f, 0.0f, 0.0f, f)), quatAxisAngle(0.0f, 1.0f, 0.0f, f2)));
    }

    public static final Position positionModelCentered(Activity activity, float f) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int i3 = (int) (i2 * f);
        int i4 = (int) (i3 * 1.5f);
        if (i4 > i) {
            i3 = (int) (i / 1.5f);
            i4 = i;
        }
        int i5 = (i - i4) / 2;
        int i6 = (i2 - i3) / 2;
        return new Position(i2, i, 0, 0);
    }

    public static final void resetWithBaseTurntable(float f, float f2, float f3) {
        resetWithBase(f, f2, f3);
        qBase = q;
        yawDeg = 0.0f;
        pitchDeg = 0.0f;
    }
}
