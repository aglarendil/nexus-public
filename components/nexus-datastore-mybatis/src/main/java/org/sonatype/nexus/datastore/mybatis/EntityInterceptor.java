/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2008-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.datastore.mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

/**
 * MyBatis {@link Interceptor} that wraps any new {@link Executor} with {@link EntityExecutor}.
 *
 * @since 3.19
 */
public class EntityInterceptor
    implements Interceptor
{
  @Override
  public Object plugin(final Object delegate) {
    if (delegate instanceof Executor) {
      return new EntityExecutor((Executor) delegate);
    }
    return delegate;
  }

  @Override
  public Object intercept(final Invocation invocation) {
    throw new UnsupportedOperationException("unused");
  }
}
