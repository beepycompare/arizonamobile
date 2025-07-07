package com.arkivanov.essenty.statekeeper;

import androidx.exifinterface.media.ExifInterface;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.JvmStreamsKt;
/* compiled from: Utils.java.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0002H\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a%\u0010\u0006\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"serialize", "", ExifInterface.GPS_DIRECTION_TRUE, "strategy", "Lkotlinx/serialization/SerializationStrategy;", "(Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)[B", "deserialize", "Lkotlinx/serialization/DeserializationStrategy;", "([BLkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "state-keeper_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Utils_javaKt {
    public static final <T> byte[] serialize(T t, SerializationStrategy<? super T> strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream2);
            ZipOutputStream zipOutputStream2 = zipOutputStream;
            zipOutputStream2.setLevel(7);
            zipOutputStream2.putNextEntry(new ZipEntry("Entry"));
            ZipOutputStream zipOutputStream3 = zipOutputStream2;
            BufferedOutputStream bufferedOutputStream = zipOutputStream3 instanceof BufferedOutputStream ? (BufferedOutputStream) zipOutputStream3 : new BufferedOutputStream(zipOutputStream3, 8192);
            JvmStreamsKt.encodeToStream(UtilsKt.getEssentyJson(), strategy, t, bufferedOutputStream);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedOutputStream, null);
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(zipOutputStream, null);
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            CloseableKt.closeFinally(byteArrayOutputStream, null);
            Intrinsics.checkNotNullExpressionValue(byteArray, "use(...)");
            return byteArray;
        } finally {
        }
    }

    public static final <T> T deserialize(byte[] bArr, DeserializationStrategy<? extends T> strategy) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(bArr));
        try {
            ZipInputStream zipInputStream2 = zipInputStream;
            zipInputStream2.getNextEntry();
            ZipInputStream zipInputStream3 = zipInputStream2;
            BufferedInputStream bufferedInputStream = zipInputStream3 instanceof BufferedInputStream ? (BufferedInputStream) zipInputStream3 : new BufferedInputStream(zipInputStream3, 8192);
            T t = (T) JvmStreamsKt.decodeFromStream(UtilsKt.getEssentyJson(), strategy, bufferedInputStream);
            CloseableKt.closeFinally(bufferedInputStream, null);
            CloseableKt.closeFinally(zipInputStream, null);
            return t;
        } finally {
        }
    }
}
