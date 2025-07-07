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
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.JobKt;
/* compiled from: EngineInterceptor.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0080@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"transform", "Lcoil3/intercept/EngineInterceptor$ExecuteResult;", "result", "request", "Lcoil3/request/ImageRequest;", "options", "Lcoil3/request/Options;", "eventListener", "Lcoil3/EventListener;", "logger", "Lcoil3/util/Logger;", "(Lcoil3/intercept/EngineInterceptor$ExecuteResult;Lcoil3/request/ImageRequest;Lcoil3/request/Options;Lcoil3/EventListener;Lcoil3/util/Logger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EngineInterceptorKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0104  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00eb -> B:32:0x00f2). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object transform(EngineInterceptor.ExecuteResult executeResult, ImageRequest imageRequest, Options options, EventListener eventListener, Logger logger, Continuation<? super EngineInterceptor.ExecuteResult> continuation) {
        EngineInterceptorKt$transform$1 engineInterceptorKt$transform$1;
        int i;
        Options options2;
        ImageRequest imageRequest2;
        EventListener eventListener2;
        EngineInterceptor.ExecuteResult executeResult2;
        List<Transformation> list;
        Bitmap bitmap;
        int size;
        int i2;
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
                        Image image = executeResult.getImage();
                        if ((image instanceof BitmapImage) || ImageRequestsKt.getAllowConversionToBitmap(imageRequest)) {
                            options2 = options;
                            Bitmap convertImageToBitmap = EngineInterceptor_androidKt.convertImageToBitmap(image, options2, transformations, logger);
                            imageRequest2 = imageRequest;
                            eventListener2 = eventListener;
                            eventListener2.transformStart(imageRequest2, convertImageToBitmap);
                            executeResult2 = executeResult;
                            list = transformations;
                            bitmap = convertImageToBitmap;
                            size = transformations.size();
                            i2 = 0;
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
                    size = engineInterceptorKt$transform$1.I$1;
                    int i3 = engineInterceptorKt$transform$1.I$0;
                    eventListener2 = (EventListener) engineInterceptorKt$transform$1.L$3;
                    Options options3 = (Options) engineInterceptorKt$transform$1.L$2;
                    ImageRequest imageRequest3 = (ImageRequest) engineInterceptorKt$transform$1.L$1;
                    EngineInterceptor.ExecuteResult executeResult3 = (EngineInterceptor.ExecuteResult) engineInterceptorKt$transform$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    List<Transformation> list2 = (List) engineInterceptorKt$transform$1.L$4;
                    options2 = options3;
                    bitmap = (Bitmap) obj;
                    JobKt.ensureActive(engineInterceptorKt$transform$1.getContext());
                    List<Transformation> list3 = list2;
                    i2 = i3 + 1;
                    imageRequest2 = imageRequest3;
                    executeResult2 = executeResult3;
                    list = list3;
                    if (i2 < size) {
                        Size size2 = options2.getSize();
                        engineInterceptorKt$transform$1.L$0 = executeResult2;
                        engineInterceptorKt$transform$1.L$1 = imageRequest2;
                        engineInterceptorKt$transform$1.L$2 = options2;
                        engineInterceptorKt$transform$1.L$3 = eventListener2;
                        engineInterceptorKt$transform$1.L$4 = list;
                        engineInterceptorKt$transform$1.I$0 = i2;
                        engineInterceptorKt$transform$1.I$1 = size;
                        engineInterceptorKt$transform$1.label = 1;
                        obj = list.get(i2).transform(bitmap, size2, engineInterceptorKt$transform$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        EngineInterceptor.ExecuteResult executeResult4 = executeResult2;
                        imageRequest3 = imageRequest2;
                        i3 = i2;
                        list2 = list;
                        executeResult3 = executeResult4;
                        bitmap = (Bitmap) obj;
                        JobKt.ensureActive(engineInterceptorKt$transform$1.getContext());
                        List<Transformation> list32 = list2;
                        i2 = i3 + 1;
                        imageRequest2 = imageRequest3;
                        executeResult2 = executeResult3;
                        list = list32;
                        if (i2 < size) {
                            eventListener2.transformEnd(imageRequest2, bitmap);
                            return EngineInterceptor.ExecuteResult.copy$default(executeResult2, Image_androidKt.asImage$default(bitmap, false, 1, null), false, null, null, 14, null);
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
