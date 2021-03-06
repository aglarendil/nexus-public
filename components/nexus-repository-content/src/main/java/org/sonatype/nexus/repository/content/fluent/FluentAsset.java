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
package org.sonatype.nexus.repository.content.fluent;

import org.sonatype.nexus.blobstore.api.Blob;
import org.sonatype.nexus.repository.content.Asset;
import org.sonatype.nexus.repository.storage.TempBlob;
import org.sonatype.nexus.repository.view.Payload;

/**
 * Fluent API for a particular asset.
 *
 * @since 3.next
 */
public interface FluentAsset
    extends Asset, FluentAttributes<FluentAsset>
{
  /**
   * Converts a temporary blob into a permanent blob and attaches it to this asset.
   */
  FluentAsset attach(TempBlob blob);

  /**
   * Attaches an existing blob to this asset.
   */
  FluentAsset attach(Blob blob);

  /**
   * Downloads this asset.
   */
  Payload download();

  /**
   * Deletes this asset.
   */
  void delete();
}
