package com.ssm.generator;

import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.exception.ShellException;

import java.io.File;
import java.util.StringTokenizer;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 *
 * @ClassName: ShellCallBack
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: HY
 * @date: 2018-05-20 13:14
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-05-20   HY           v1.0.0             修改原因
 */
public class BlogsShellCallBack implements ShellCallback {
    /** The overwrite. */
    private boolean overwrite;

    /**
     *
     */
    public BlogsShellCallBack() {
        super();
        this.overwrite = true;
    }

    /**
     *
     * @param overwrite
     *            the overwrite
     */
    public BlogsShellCallBack(boolean overwrite) {
        super();
        this.overwrite = overwrite;
    }

    /* (non-Javadoc)
     * @see org.mybatis.generator.api.ShellCallback#getDirectory(java.lang.String, java.lang.String)
     */
    public File getDirectory(String targetProject, String targetPackage)
            throws ShellException {
        // targetProject is interpreted as a directory that must exist
        //
        // targetPackage is interpreted as a sub directory, but in package
        // format (with dots instead of slashes). The sub directory will be
        // created
        // if it does not already exist

        File project = new File(targetProject);
        if (!project.isDirectory()) {
            throw new ShellException(getString("Warning.9", //$NON-NLS-1$
                    targetProject));
        }

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(targetPackage, "."); //$NON-NLS-1$
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken());
            sb.append(File.separatorChar);
        }

        File directory = new File(project, sb.toString());
        if (!directory.isDirectory()) {
            boolean rc = directory.mkdirs();
            if (!rc) {
                throw new ShellException(getString("Warning.10", //$NON-NLS-1$
                        directory.getAbsolutePath()));
            }
        }

        return directory;
    }

    /* (non-Javadoc)
     * @see org.mybatis.generator.api.ShellCallback#refreshProject(java.lang.String)
     */
    public void refreshProject(String project) {
        // nothing to do in the default shell callback
    }

    /* (non-Javadoc)
     * @see org.mybatis.generator.api.ShellCallback#isMergeSupported()
     */
    public boolean isMergeSupported() {
        return true;
    }

    /* (non-Javadoc)
     * @see org.mybatis.generator.api.ShellCallback#isOverwriteEnabled()
     */
    public boolean isOverwriteEnabled() {
        return overwrite;
    }

    /* (non-Javadoc)
     * @see org.mybatis.generator.api.ShellCallback#mergeJavaFile(java.lang.String, java.lang.String, java.lang.String[], java.lang.String)
     */
    public String mergeJavaFile(String newFileSource,
                                String existingFileFullPath, String[] javadocTags, String fileEncoding)
            throws ShellException {

        JavaFileMerger merger = new
                JavaFileMerger(newFileSource, existingFileFullPath, javadocTags,
                fileEncoding);
        return merger.getMergedSource();

        //throw new UnsupportedOperationException();
    }
}
