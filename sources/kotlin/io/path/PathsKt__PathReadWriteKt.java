package kotlin.io.path;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
/* compiled from: PathReadWrite.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u0010\b\u001a:\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u0010\r\u001a0\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u0010\u0010\u001a:\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0015*\u00020\u0002H\u0087\b\u001a.\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00152\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u0010\u0019\u001a\u0015\u0010\u001a\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015H\u0087\b\u001a\u0016\u0010\u001b\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a7\u0010\u001d\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0007¢\u0006\u0002\u0010 \u001a\u001e\u0010!\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a=\u0010\"\u001a\u00020\u0017*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00170$H\u0087\bø\u0001\u0000\u001a&\u0010(\u001a\u00020)*\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u0010*\u001a&\u0010+\u001a\u00020,*\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u0010-\u001a\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001c0/*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001aL\u00100\u001a\u0002H1\"\u0004\b\u0000\u00101*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c03\u0012\u0004\u0012\u0002H10$H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u00104\u001a>\u00105\u001a\u00020\u0002*\u00020\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f072\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u00108\u001a>\u00105\u001a\u00020\u0002*\u00020\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f032\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0087\b¢\u0006\u0002\u00109\u001a%\u0010:\u001a\u00020\u0002*\u00020\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f072\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a%\u0010:\u001a\u00020\u0002*\u00020\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f032\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006;"}, d2 = {"reader", "Ljava/io/InputStreamReader;", "Ljava/nio/file/Path;", "charset", "Ljava/nio/charset/Charset;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "writer", "Ljava/io/OutputStreamWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;", "bufferedWriter", "Ljava/io/BufferedWriter;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "readBytes", "", "writeBytes", "", "array", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "appendBytes", "readText", "", "writeText", "text", "", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "appendText", "forEachLine", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "readLines", "", "useLines", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeLines", "lines", "", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "appendLines", "kotlin-stdlib-jdk7"}, k = 5, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, xs = "kotlin/io/path/PathsKt")
/* loaded from: classes5.dex */
class PathsKt__PathReadWriteKt {
    static /* synthetic */ InputStreamReader reader$default(Path path, Charset charset, OpenOption[] options, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    private static final InputStreamReader reader(Path path, Charset charset, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(Path path, Charset charset, int i, OpenOption[] options, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i);
    }

    private static final BufferedReader bufferedReader(Path path, Charset charset, int i, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i);
    }

    static /* synthetic */ OutputStreamWriter writer$default(Path path, Charset charset, OpenOption[] options, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    private static final OutputStreamWriter writer(Path path, Charset charset, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(Path path, Charset charset, int i, OpenOption[] options, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i);
    }

    private static final BufferedWriter bufferedWriter(Path path, Charset charset, int i, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length)), charset), i);
    }

    private static final byte[] readBytes(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        byte[] readAllBytes = Files.readAllBytes(path);
        Intrinsics.checkNotNullExpressionValue(readAllBytes, "readAllBytes(...)");
        return readAllBytes;
    }

    private static final void writeBytes(Path path, byte[] array, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        Intrinsics.checkNotNullParameter(options, "options");
        Files.write(path, array, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    private static final void appendBytes(Path path, byte[] array) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        Files.write(path, array, StandardOpenOption.APPEND);
    }

    public static /* synthetic */ String readText$default(Path path, Charset charset, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return PathsKt.readText(path, charset);
    }

    public static final String readText(Path path, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), charset);
        try {
            String readText = TextStreamsKt.readText(inputStreamReader);
            CloseableKt.closeFinally(inputStreamReader, null);
            return readText;
        } finally {
        }
    }

    public static /* synthetic */ void writeText$default(Path path, CharSequence charSequence, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        PathsKt.writeText(path, charSequence, charset, openOptionArr);
    }

    public static final void writeText(Path path, CharSequence text, Charset charset, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        OutputStream newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        try {
            OutputStream outputStream = newOutputStream;
            if (text instanceof String) {
                Intrinsics.checkNotNull(outputStream);
                FilesKt.writeTextImpl(outputStream, (String) text, charset);
            } else {
                CharsetEncoder newReplaceEncoder = FilesKt.newReplaceEncoder(charset);
                CharBuffer asReadOnlyBuffer = text instanceof CharBuffer ? ((CharBuffer) text).asReadOnlyBuffer() : CharBuffer.wrap(text);
                int min = Math.min(text.length(), 8192);
                Intrinsics.checkNotNull(newReplaceEncoder);
                ByteBuffer byteBufferForEncoding = FilesKt.byteBufferForEncoding(min, newReplaceEncoder);
                while (asReadOnlyBuffer.hasRemaining()) {
                    if (newReplaceEncoder.encode(asReadOnlyBuffer, byteBufferForEncoding, true).isError()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    outputStream.write(byteBufferForEncoding.array(), 0, byteBufferForEncoding.position());
                    byteBufferForEncoding.clear();
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(newOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(newOutputStream, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void appendText$default(Path path, CharSequence charSequence, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        PathsKt.appendText(path, charSequence, charset);
    }

    public static final void appendText(Path path, CharSequence text, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        PathsKt.writeText(path, text, charset, StandardOpenOption.APPEND);
    }

    static /* synthetic */ void forEachLine$default(Path path, Charset charset, Function1 action, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(action, "action");
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        Intrinsics.checkNotNullExpressionValue(newBufferedReader, "newBufferedReader(...)");
        BufferedReader bufferedReader = newBufferedReader;
        try {
            for (String str : TextStreamsKt.lineSequence(bufferedReader)) {
                action.invoke(str);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedReader, null);
        } finally {
        }
    }

    private static final void forEachLine(Path path, Charset charset, Function1<? super String, Unit> action) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(action, "action");
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        Intrinsics.checkNotNullExpressionValue(newBufferedReader, "newBufferedReader(...)");
        BufferedReader bufferedReader = newBufferedReader;
        try {
            for (String str : TextStreamsKt.lineSequence(bufferedReader)) {
                action.invoke(str);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedReader, null);
        } finally {
        }
    }

    private static final InputStream inputStream(Path path, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        InputStream newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(newInputStream, "newInputStream(...)");
        return newInputStream;
    }

    private static final OutputStream outputStream(Path path, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        OutputStream newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(newOutputStream, "newOutputStream(...)");
        return newOutputStream;
    }

    static /* synthetic */ List readLines$default(Path path, Charset charset, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        List<String> readAllLines = Files.readAllLines(path, charset);
        Intrinsics.checkNotNullExpressionValue(readAllLines, "readAllLines(...)");
        return readAllLines;
    }

    private static final List<String> readLines(Path path, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        List<String> readAllLines = Files.readAllLines(path, charset);
        Intrinsics.checkNotNullExpressionValue(readAllLines, "readAllLines(...)");
        return readAllLines;
    }

    static /* synthetic */ Object useLines$default(Path path, Charset charset, Function1 block, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(block, "block");
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        try {
            BufferedReader bufferedReader = newBufferedReader;
            Intrinsics.checkNotNull(bufferedReader);
            Object invoke = block.invoke(TextStreamsKt.lineSequence(bufferedReader));
            CloseableKt.closeFinally(newBufferedReader, null);
            return invoke;
        } finally {
        }
    }

    private static final <T> T useLines(Path path, Charset charset, Function1<? super Sequence<String>, ? extends T> block) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(block, "block");
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        try {
            BufferedReader bufferedReader = newBufferedReader;
            Intrinsics.checkNotNull(bufferedReader);
            T invoke = block.invoke(TextStreamsKt.lineSequence(bufferedReader));
            CloseableKt.closeFinally(newBufferedReader, null);
            return invoke;
        } finally {
        }
    }

    static /* synthetic */ Path writeLines$default(Path path, Iterable lines, Charset charset, OpenOption[] options, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        Path write = Files.write(path, lines, charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(write, "write(...)");
        return write;
    }

    private static final Path writeLines(Path path, Iterable<? extends CharSequence> lines, Charset charset, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        Path write = Files.write(path, lines, charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(write, "write(...)");
        return write;
    }

    static /* synthetic */ Path writeLines$default(Path path, Sequence lines, Charset charset, OpenOption[] options, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        Path write = Files.write(path, SequencesKt.asIterable(lines), charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(write, "write(...)");
        return write;
    }

    private static final Path writeLines(Path path, Sequence<? extends CharSequence> lines, Charset charset, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(options, "options");
        Path write = Files.write(path, SequencesKt.asIterable(lines), charset, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(write, "write(...)");
        return write;
    }

    static /* synthetic */ Path appendLines$default(Path path, Iterable lines, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Path write = Files.write(path, lines, charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "write(...)");
        return write;
    }

    private static final Path appendLines(Path path, Iterable<? extends CharSequence> lines, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Path write = Files.write(path, lines, charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "write(...)");
        return write;
    }

    static /* synthetic */ Path appendLines$default(Path path, Sequence lines, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Path write = Files.write(path, SequencesKt.asIterable(lines), charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "write(...)");
        return write;
    }

    private static final Path appendLines(Path path, Sequence<? extends CharSequence> lines, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Path write = Files.write(path, SequencesKt.asIterable(lines), charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "write(...)");
        return write;
    }
}
