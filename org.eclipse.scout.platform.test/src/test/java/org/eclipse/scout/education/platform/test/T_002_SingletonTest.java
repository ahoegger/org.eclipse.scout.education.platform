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

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Bean;
import org.eclipse.scout.rt.testing.platform.runner.PlatformTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(PlatformTestRunner.class)
public class T_002_SingletonTest {

  @Test
  public void testMyBean() {
    T_002_MultiIntanceBean bean01 = BEANS.get(T_002_MultiIntanceBean.class);
    Assert.assertNotNull(bean01);

    T_002_MultiIntanceBean bean02 = BEANS.get(T_002_MultiIntanceBean.class);
    Assert.assertNotNull(bean02);

    Assert.assertNotSame(bean01, bean02);
  }

  @Test
  public void testSingleton() {
    T_002_SingletonBean bean01 = BEANS.get(T_002_SingletonBean.class);
    Assert.assertNotNull(bean01);

    T_002_SingletonBean bean02 = BEANS.get(T_002_SingletonBean.class);
    Assert.assertNotNull(bean02);

    Assert.assertSame(bean01, bean02);
  }

  @Bean
  public static class T_002_MultiIntanceBean {

  }

  @Bean
  @ApplicationScoped
  public static class T_002_SingletonBean {

  }

}
