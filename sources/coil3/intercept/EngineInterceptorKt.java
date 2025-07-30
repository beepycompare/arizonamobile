package coil3.intercept;

import android.graphics.Bitmap;
import coil3.BitmapImage;
import coil3.EventListener;
import coil3.Image;
import coil3.Image_androidKt;
import coil3.intercept.EngineInterceptor;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import coil3.request.Options;
import coil3.size.Size;
import coil3.transform.Transformation;
import coil3.util.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.JobKt;
/* compiled from: EngineInterceptor.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0080@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"transform", "Lcoil3/intercept/EngineInterceptor$ExecuteResult;", "result", "request", "Lcoil3/request/ImageRequest;", "options", "Lcoil3/request/Options;", "eventListener", "Lcoil3/EventListener;", "logger", "Lcoil3/util/Logger;", "(Lcoil3/intercept/EngineInterceptor$ExecuteResult;Lcoil3/request/ImageRequest;Lcoil3/request/Options;Lcoil3/EventListener;Lcoil3/util/Logger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-core_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EngineInterceptorKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x016e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0158 -> B:32:0x015d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object transform(EngineInterceptor.ExecuteResult executeResult, ImageRequest imageRequest, Options options, EventListener eventListener, Logger logger, Continuation<? super EngineInterceptor.ExecuteResult> continuation) {
        EngineInterceptorKt$transform$1 engineInterceptorKt$transform$1;
        int i;
        Options options2;
        Bitmap convertImageToBitmap;
        ImageRequest imageRequest2;
        EventListener eventListener2;
        int size;
        List<Transformation> list;
        List<Transformation> list2;
        Image image;
        Bitmap bitmap;
        Bitmap bitmap2;
        int i2;
        int i3;
        Logger logger2;
        EngineInterceptor.ExecuteResult executeResult2;
        if (continuation instanceof EngineInterceptorKt$transform$1) {
            engineInterceptorKt$transform$1 = (EngineInterceptorKt$transform$1) continuation;
            if ((engineInterceptorKt$transform$1.label & Integer.MIN_VALUE) != 0) {
                engineInterceptorKt$transform$1.label -= Integer.MIN_VALUE;
                Object obj = engineInterceptorKt$transform$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = engineInterceptorKt$transform$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    List<Transformation> transformations = ImageRequestsKt.getTransformations(imageRequest);
                    if (!transformations.isEmpty()) {
                        Image image2 = executeResult.getImage();
                        if ((image2 instanceof BitmapImage) || ImageRequestsKt.getAllowConversionToBitmap(imageRequest)) {
                            options2 = options;
                            convertImageToBitmap = EngineInterceptor_androidKt.convertImageToBitmap(image2, options2, transformations, logger);
                            imageRequest2 = imageRequest;
                            eventListener2 = eventListener;
                            eventListener2.transformStart(imageRequest2, convertImageToBitmap);
                            size = transformations.size();
                            list = transformations;
                            list2 = list;
                            image = image2;
                            bitmap = convertImageToBitmap;
                            bitmap2 = bitmap;
                            i2 = 0;
                            i3 = 0;
                            logger2 = logger;
                            executeResult2 = executeResult;
                            if (i2 < size) {
                            }
                        } else if (logger != null) {
                            Logger.Level level = Logger.Level.Info;
                            if (logger.getMinLevel().compareTo(level) <= 0) {
                                logger.log(EngineInterceptor.TAG, level, "allowConversionToBitmap=false, skipping transformations for type " + Reflection.getOrCreateKotlinClass(executeResult.getImage().getClass()).getSimpleName() + '.', null);
                            }
                        }
                    }
                    return executeResult;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i4 = engineInterceptorKt$transform$1.I$3;
                    int i5 = engineInterceptorKt$transform$1.I$2;
                    i2 = engineInterceptorKt$transform$1.I$1;
                    int i6 = engineInterceptorKt$transform$1.I$0;
                    Bitmap bitmap3 = (Bitmap) engineInterceptorKt$transform$1.L$12;
                    Transformation transformation = (Transformation) engineInterceptorKt$transform$1.L$11;
                    Bitmap bitmap4 = (Bitmap) engineInterceptorKt$transform$1.L$10;
                    Logger logger3 = (Logger) engineInterceptorKt$transform$1.L$4;
                    ResultKt.throwOnFailure(obj);
                    EngineInterceptor.ExecuteResult executeResult3 = (EngineInterceptor.ExecuteResult) engineInterceptorKt$transform$1.L$0;
                    options2 = (Options) engineInterceptorKt$transform$1.L$2;
                    imageRequest2 = (ImageRequest) engineInterceptorKt$transform$1.L$1;
                    Image image3 = (Image) engineInterceptorKt$transform$1.L$6;
                    list = (List) engineInterceptorKt$transform$1.L$8;
                    i3 = i6;
                    eventListener2 = (EventListener) engineInterceptorKt$transform$1.L$3;
                    list2 = (List) engineInterceptorKt$transform$1.L$5;
                    bitmap2 = (Bitmap) engineInterceptorKt$transform$1.L$7;
                    bitmap = (Bitmap) engineInterceptorKt$transform$1.L$9;
                    size = i5;
                    int i7 = 1;
                    JobKt.ensureActive(engineInterceptorKt$transform$1.getContext());
                    i2 += i7;
                    Image image4 = image3;
                    convertImageToBitmap = (Bitmap) obj;
                    logger2 = logger3;
                    image = image4;
                    executeResult2 = executeResult3;
                    if (i2 < size) {
                        Logger logger4 = logger2;
                        Transformation transformation2 = list.get(i2);
                        Bitmap bitmap5 = bitmap;
                        Size size2 = options2.getSize();
                        engineInterceptorKt$transform$1.L$0 = executeResult2;
                        engineInterceptorKt$transform$1.L$1 = imageRequest2;
                        engineInterceptorKt$transform$1.L$2 = options2;
                        engineInterceptorKt$transform$1.L$3 = eventListener2;
                        executeResult3 = executeResult2;
                        engineInterceptorKt$transform$1.L$4 = SpillingKt.nullOutSpilledVariable(logger4);
                        engineInterceptorKt$transform$1.L$5 = SpillingKt.nullOutSpilledVariable(list2);
                        engineInterceptorKt$transform$1.L$6 = SpillingKt.nullOutSpilledVariable(image);
                        engineInterceptorKt$transform$1.L$7 = SpillingKt.nullOutSpilledVariable(bitmap2);
                        engineInterceptorKt$transform$1.L$8 = list;
                        engineInterceptorKt$transform$1.L$9 = SpillingKt.nullOutSpilledVariable(bitmap5);
                        engineInterceptorKt$transform$1.L$10 = SpillingKt.nullOutSpilledVariable(convertImageToBitmap);
                        engineInterceptorKt$transform$1.L$11 = SpillingKt.nullOutSpilledVariable(transformation2);
                        engineInterceptorKt$transform$1.L$12 = SpillingKt.nullOutSpilledVariable(convertImageToBitmap);
                        engineInterceptorKt$transform$1.I$0 = i3;
                        engineInterceptorKt$transform$1.I$1 = i2;
                        engineInterceptorKt$transform$1.I$2 = size;
                        engineInterceptorKt$transform$1.I$3 = 0;
                        i7 = 1;
                        engineInterceptorKt$transform$1.label = 1;
                        obj = transformation2.transform(convertImageToBitmap, size2, engineInterceptorKt$transform$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        bitmap = bitmap5;
                        image3 = image;
                        logger3 = logger4;
                        JobKt.ensureActive(engineInterceptorKt$transform$1.getContext());
                        i2 += i7;
                        Image image42 = image3;
                        convertImageToBitmap = (Bitmap) obj;
                        logger2 = logger3;
                        image = image42;
                        executeResult2 = executeResult3;
                        if (i2 < size) {
                            eventListener2.transformEnd(imageRequest2, convertImageToBitmap);
                            return EngineInterceptor.ExecuteResult.copy$default(executeResult2, Image_androidKt.asImage$default(convertImageToBitmap, false, 1, null), false, null, null, 14, null);
                        }
                    }
                }
            }
        }
        engineInterceptorKt$transform$1 = new EngineInterceptorKt$transform$1(continuation);
        Object obj2 = engineInterceptorKt$transform$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = engineInterceptorKt$transform$1.label;
        if (i != 0) {
        }
    }
}
