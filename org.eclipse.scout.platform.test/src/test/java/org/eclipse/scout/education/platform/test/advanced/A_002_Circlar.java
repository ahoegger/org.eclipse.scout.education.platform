/*******************************************************************************
 * Copyright (c) 2015 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.scout.education.platform.test.advanced;

import javax.annotation.PostConstruct;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Bean;
import org.eclipse.scout.rt.testing.platform.runner.PlatformTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(PlatformTestRunner.class)
public class A_002_Circlar {

  @Test
  public void testMyBean() {
    Assert.assertNotNull(BEANS.get(A_002_Bean02.class));
  }

  public static class A_002_Bean01 {
    @PostConstruct
    protected void init() {
      BEANS.get(A_002_Bean02.class);
    }
  }

  @Bean
  public static class A_002_Bean02 {
    @PostConstruct
    protected void init() {
      BEANS.get(A_002_Bean01.class);
    }

  }
}
