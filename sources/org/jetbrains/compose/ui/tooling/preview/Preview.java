package org.jetbrains.compose.ui.tooling.preview;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Repeatable;
import kotlin.jvm.internal.RepeatableContainer;
/* compiled from: Preview.kt */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Deprecated(message = "Use androidx.compose.ui.tooling.preview.Preview from org.jetbrains.compose.ui:ui-tooling-preview module instead", replaceWith = @ReplaceWith(expression = "Preview", imports = {"androidx.compose.ui.tooling.preview.Preview"}))
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
@MustBeDocumented
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001Bp\u0012\u000e\b\u0002\u0010\u0002\u001a\u00020\u0003B\u0004\b\b(\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\u00020\u0003B\u0004\b\b(\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\u00020\u0007B\u0004\b\u0003\u0010\u0001\u0012\u000e\b\u0002\u0010\b\u001a\u00020\u0007B\u0004\b\u0003\u0010\u0001\u0012\u000e\b\u0002\u0010\t\u001a\u00020\u0003B\u0004\b\b(\u0004\u0012\u000e\b\u0002\u0010\n\u001a\u00020\u000bB\u0004\b\u0007\u0010\u0000\u0012\u000e\b\u0002\u0010\f\u001a\u00020\rB\u0004\b\u0004\u0010\u0000R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u000eR\u000f\u0010\u0005\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u000eR\u000f\u0010\u0006\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000fR\u000f\u0010\b\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\b\u0010\u000fR\u000f\u0010\t\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\t\u0010\u000eR\u000f\u0010\n\u001a\u00020\u000b¢\u0006\u0006\u001a\u0004\b\n\u0010\u0010R\u000f\u0010\f\u001a\u00020\r¢\u0006\u0006\u001a\u0004\b\f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lorg/jetbrains/compose/ui/tooling/preview/Preview;", "", "name", "", "", "group", "widthDp", "", "heightDp", "locale", "showBackground", "", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "", "()Ljava/lang/String;", "()I", "()Z", "()J", "library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Repeatable
@Documented
@java.lang.annotation.Repeatable(Container.class)
/* loaded from: classes5.dex */
public @interface Preview {

    /* compiled from: Preview.kt */
    @Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    @RepeatableContainer
    /* loaded from: classes5.dex */
    public @interface Container {
        Preview[] value();
    }

    long backgroundColor() default 0;

    String group() default "";

    int heightDp() default -1;

    String locale() default "";

    String name() default "";

    boolean showBackground() default false;

    int widthDp() default -1;
}
