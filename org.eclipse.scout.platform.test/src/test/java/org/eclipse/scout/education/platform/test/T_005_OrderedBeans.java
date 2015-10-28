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

import java.util.List;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.testing.platform.runner.PlatformTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(PlatformTestRunner.class)
public class T_005_OrderedBeans {

  @Test
  public void test() {
    T_005_BeanInterface bean = BEANS.get(T_005_BeanInterface.class);
    Assert.assertSame(T_005_Bean2.class, bean.getClass());

    List<T_005_BeanInterface> all = BEANS.all(T_005_BeanInterface.class);
    Assert.assertSame(T_005_Bean2.class, all.get(0).getClass());
    Assert.assertSame(T_005_Bean1.class, all.get(1).getClass());
  }

  @ApplicationScoped
  public static interface T_005_BeanInterface {

  }

  @Order(20)
  public static class T_005_Bean1 implements T_005_BeanInterface {

  }

  @Order(10)
  public static class T_005_Bean2 implements T_005_BeanInterface {

  }

}
