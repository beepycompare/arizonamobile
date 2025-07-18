package com.google.common.io;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Resources {
    private Resources() {
    }

    public static ByteSource asByteSource(URL url) {
        return new UrlByteSource(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class UrlByteSource extends ByteSource {
        private final URL url;

        private UrlByteSource(URL url) {
            this.url = (URL) Preconditions.checkNotNull(url);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return this.url.openStream();
        }

        public String toString() {
            return "Resources.asByteSource(" + this.url + ")";
        }
    }

    public static CharSource asCharSource(URL url, Charset charset) {
        return asByteSource(url).asCharSource(charset);
    }

    public static byte[] toByteArray(URL url) throws IOException {
        return asByteSource(url).read();
    }

    public static String toString(URL url, Charset charset) throws IOException {
        return asCharSource(url, charset).read();
    }

    @ParametricNullness
    public static <T> T readLines(URL url, Charset charset, LineProcessor<T> callback) throws IOException {
        return (T) asCharSource(url, charset).readLines(callback);
    }

    public static List<String> readLines(URL url, Charset charset) throws IOException {
        return (List) readLines(url, charset, new LineProcessor<List<String>>() { // from class: com.google.common.io.Resources.1
            final List<String> result = Lists.newArrayList();

            @Override // com.google.common.io.LineProcessor
            public boolean processLine(String line) {
                this.result.add(line);
                return true;
            }

            @Override // com.google.common.io.LineProcessor
            public List<String> getResult() {
                return this.result;
            }
        });
    }

    public static void copy(URL from, OutputStream to) throws IOException {
        asByteSource(from).copyTo(to);
    }

    public static URL getResource(String resourceName) {
        URL resource = ((ClassLoader) MoreObjects.firstNonNull(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader())).getResource(resourceName);
        Preconditions.checkArgument(resource != null, "resource %s not found.", resourceName);
        return resource;
    }

    public static URL getResource(Class<?> contextClass, String resourceName) {
        URL resource = contextClass.getResource(resourceName);
        Preconditions.checkArgument(resource != null, "resource %s relative to %s not found.", resourceName, contextClass.getName());
        return resource;
    }
}
