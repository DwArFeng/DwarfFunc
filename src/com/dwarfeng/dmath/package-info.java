/**
 * 数学包。
 * <p> 这个包来源于之前我写过的math包。由于之前我是初步接触java，因此math包写的很是不好，中途只得放弃。
 * 现在，我打算将以前的工作重新整合起来，整合在我的工具包中，并且用dmath这个包进行封装。
 * <br> dmath包涉及代数、几何、统计、线性代数四大方面的内容，每个方面的内容都来自相对应的数学学科。
 * 
 * <p> <b>同步问题：</b>
 * 
 * <p> 基本上，所有的数学对象都不是线程安全的，如果要将其用在多线程中，请注意外部同步。如果
 * 其中的某个数学类是线程安全的，会在文档中指明，除此之外，其余的类都是线程不安全的。
 * 
 * <p><b>几个概念：</b>
 * 
 * <p><b>对象是否可变以及一个对象是否接受可变对象：</b>
 * 
 * <br>可变对象是指一个对象中的元素的状态可以变，而不是指
 * 一个对象的结构可以改变。比如算式 <code> 3 * x</code>，这是一个可变对象，因为<code>3 * x</code>的值会随着<code>x</code>
 * 的变化而变化，但是，可变对象仅仅限于结构可变，无论如何，该式子不能变成<code>3 + x</code>也就是结构是无法变化的。
 * 不可变对象可变是指一个无论是结构还是值或者是其它的状态自构造起就永远不可变。
 * <br>接收可变对象的对象一定是可变对象，反之，只接收不可变对象的对象不一定是不可变对象。
 * <br>不过，可变对象并不是在任何时候都可编辑，比如一个可变对象接收 {@link com.dwarfeng.dmath.algebra.Valueable}对象，
 * 所以这个对象是可变的对象，然而在传入参数时，却传入几个常量，这样，虽然这个对象是可变对象，却没有任何方法能够修改
 * 这个对象。因此，可变对象继承 {@link com.dwarfeng.dmath.MayChange}接口，并且通过调用
 * {@link com.dwarfeng.dmath.MayChange#canModify()}方法来查询这个类究竟是否可变。
 * 
 * <p><b>关于运算（尤其是代数）：</b>
 * <br> 数学包中的运算分为算式运算和值运算。算式运算是通过算式类将不同的对象构造成一个算式，比如代数中的 TODO 算式
 * 算式运算是在保留原有的对象的结构上进行的运算，因此，如果原有对象中含有可变对象，则算式运算也是可变的。
 * 另一种运算是值运算，比如线性代数包中的//TODO 行向量类，该类具有行向量的运算方法，这些方法是封装在类的内部的
 * 在调用这些方法时，会对对象内在的 {@link com.dwarfeng.dmath.algebra.Valueable} 对象进行取值，返回
 * 的新对象只保留运算之后的值，所以值运算时破坏性的，通过值运算返回的结果不在用于运算元素的特性，即使参与运算的
 * 对象时可变的，通过运算获得的结果对象也同样是不可修改的。
 * 
 * 
 * @author DwArFeng
 * @since 1.8
 */
package com.dwarfeng.dmath;