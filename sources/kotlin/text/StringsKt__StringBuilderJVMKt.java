package kotlin.text;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StringBuilderJVM.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\u001a4\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\bb\u0002\b\t\u001a4\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\bb\u0002\b\t\u001a<\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\bb\u0002\b\t\u001a<\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\nH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\bb\u0002\b\t\u001a(\u0010\u000e\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0087\u0080\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000fb\u0002\b\t\u001a&\u0010\u0010\u001a\u00020\u0011*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0012H\u0087\u008a\u0004b\u0002\b\b\u001aD\u0010\u0013\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0016H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010\u0018\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a<\u0010\u0019\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001aJ\u0010\u001a\u001a\u00020\u0011*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\rH\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\b\u001aD\u0010\u001e\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001aD\u0010\u001e\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001aL\u0010 \u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001aL\u0010 \u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a6\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\"H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a<\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\rH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020#H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020$H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001a4\u0010!\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020%H\u0087\u0088\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017b\u0002\b\bb\u0002\b\t\u001aZ\u0010&\u001a\u00060'j\u0002`(*\u00060'j\u0002`(H\u0087\u0080\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4\u001ah\u0010&\u001a\u00060'j\u0002`(*\u00060'j\u0002`(2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001fH\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060'j\u0002`(*\u00060'j\u0002`(2\u0006\u0010\u0003\u001a\u00020\u0012H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001aZ\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0087\u0080\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4\u001ah\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\"H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001ah\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u001fH\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001ah\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0016H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001ah\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u000106H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001an\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001cH\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0012H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u000207H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\rH\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020#H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020$H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b\u001af\u0010&\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020%H\u0087\u0088\u0004b*\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u001c\b,\u0012\u0018\b\u000bB\u0014\b-\u0012\b\b.\u0012\u0004\b\b(5\u0012\u0006\b0\u0012\u0002\b\fb\u0016\b1\u0012\b\b2\u0012\u0004\b\b(\u0017\u0012\b\b3\u0012\u0004\b\b(4b\u0002\b\b¨\u00068"}, d2 = {"append", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.9", "Lkotlin/internal/InlineOnly;", "Lkotlin/IgnorableReturnValue;", "", "insert", FirebaseAnalytics.Param.INDEX, "", "clear", "1.3", "set", "", "", "setRange", "startIndex", "endIndex", "", "1.4", "deleteAt", "deleteRange", "toCharArray", FirebaseAnalytics.Param.DESTINATION, "", "destinationOffset", "appendRange", "", "insertRange", "appendLine", "Ljava/lang/StringBuffer;", "", "", "", "appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "Lkotlin/Deprecated;", "message", "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "appendLine()", "imports", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "errorSince", "2.1", "appendLine(value)", "", "", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes5.dex */
class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    @IgnorableReturnValue
    private static final StringBuilder append(StringBuilder sb, byte b) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append((int) b);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append;
    }

    @IgnorableReturnValue
    private static final StringBuilder append(StringBuilder sb, short s) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append((int) s);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append;
    }

    @IgnorableReturnValue
    private static final StringBuilder insert(StringBuilder sb, int i, byte b) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder insert = sb.insert(i, (int) b);
        Intrinsics.checkNotNullExpressionValue(insert, "insert(...)");
        return insert;
    }

    @IgnorableReturnValue
    private static final StringBuilder insert(StringBuilder sb, int i, short s) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder insert = sb.insert(i, (int) s);
        Intrinsics.checkNotNullExpressionValue(insert, "insert(...)");
        return insert;
    }

    @IgnorableReturnValue
    public static final StringBuilder clear(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.setLength(0);
        return sb;
    }

    private static final void set(StringBuilder sb, int i, char c) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        sb.setCharAt(i, c);
    }

    @IgnorableReturnValue
    private static final StringBuilder setRange(StringBuilder sb, int i, int i2, String value) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder replace = sb.replace(i, i2, value);
        Intrinsics.checkNotNullExpressionValue(replace, "replace(...)");
        return replace;
    }

    @IgnorableReturnValue
    private static final StringBuilder deleteAt(StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder deleteCharAt = sb.deleteCharAt(i);
        Intrinsics.checkNotNullExpressionValue(deleteCharAt, "deleteCharAt(...)");
        return deleteCharAt;
    }

    @IgnorableReturnValue
    private static final StringBuilder deleteRange(StringBuilder sb, int i, int i2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder delete = sb.delete(i, i2);
        Intrinsics.checkNotNullExpressionValue(delete, "delete(...)");
        return delete;
    }

    static /* synthetic */ void toCharArray$default(StringBuilder sb, char[] destination, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sb.length();
        }
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        sb.getChars(i2, i3, destination, i);
    }

    private static final void toCharArray(StringBuilder sb, char[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        sb.getChars(i2, i3, destination, i);
    }

    @IgnorableReturnValue
    private static final StringBuilder appendRange(StringBuilder sb, char[] value, int i, int i2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder append = sb.append(value, i, i2 - i);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append;
    }

    @IgnorableReturnValue
    private static final StringBuilder appendRange(StringBuilder sb, CharSequence value, int i, int i2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder append = sb.append(value, i, i2);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append;
    }

    @IgnorableReturnValue
    private static final StringBuilder insertRange(StringBuilder sb, int i, char[] value, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder insert = sb.insert(i, value, i2, i3 - i2);
        Intrinsics.checkNotNullExpressionValue(insert, "insert(...)");
        return insert;
    }

    @IgnorableReturnValue
    private static final StringBuilder insertRange(StringBuilder sb, int i, CharSequence value, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder insert = sb.insert(i, value, i2, i3);
        Intrinsics.checkNotNullExpressionValue(insert, "insert(...)");
        return insert;
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder sb, StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(stringBuffer);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder sb, StringBuilder sb2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append((CharSequence) sb2);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(i);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder sb, short s) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append((int) s);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder sb, byte b) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append((int) b);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder sb, long j) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(j);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder sb, float f) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(f);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder sb, double d) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(d);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append.append('\n');
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    public static final Appendable appendln(Appendable appendable) {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Appendable append = appendable.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append;
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final Appendable appendln(Appendable appendable, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Appendable append = appendable.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final Appendable appendln(Appendable appendable, char c) {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Appendable append = appendable.append(c);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    public static final StringBuilder appendln(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return append;
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(stringBuffer);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, String str) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(str);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, Object obj) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(obj);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, StringBuilder sb2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append((CharSequence) sb2);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, char[] value) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder append = sb.append(value);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, char c) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(c);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, boolean z) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(z);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(i);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, short s) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append((int) s);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, byte b) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append((int) b);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, long j) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(j);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, float f) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(f);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, double d) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder append = sb.append(d);
        Intrinsics.checkNotNullExpressionValue(append, "append(...)");
        return StringsKt.appendln(append);
    }
}
