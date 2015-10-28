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
package org.eclipse.scout.education.platform.test;

import org.eclipse.scout.commons.Assertions.AssertionException;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Bean;
import org.eclipse.scout.rt.testing.platform.runner.PlatformTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(PlatformTestRunner.class)
public class T_001_BeanRegistrationTest {

  @Test(expected = AssertionException.class)
  public void testGetOfUnregistered() {
    BEANS.get(T_001_UnregisteredBean.class);
  }

  @Test
  public void testOptOfUnregisteredBean() {
    Assert.assertNull(BEANS.opt(T_001_UnregisteredBean.class));
  }

  @Test
  public void testMyBean() {
    Assert.assertNotNull(BEANS.get(T_001_RegisteredBean.class));
  }

  public static class T_001_UnregisteredBean {
  }

  @Bean
  public static class T_001_RegisteredBean {

  }
}
