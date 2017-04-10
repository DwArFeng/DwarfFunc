/**
 * 算式数学包。
 * 
 * <p> 前置包： 
 * <br> {@linkplain com.dwarfeng.dutil.basic}
 * <br> {@linkplain com.dwarfeng.dutil.math}
 * 
 * <p> 这个包来源于之前我写过的math包。由于之前我是初步接触java，因此math包写的很是不好，中途只得放弃。
 * 现在，我打算将以前的工作重新整合起来，整合在我的工具包中，并且用dmath这个包进行封装。
 * <br> 该包的名字来源与formula math的简写。
 * <br> foth包目前涉及代数、线性代数等方面的内容，每个方面的内容都来自相对应的数学学科。
 * <br> foth包是支持公式结构的数学包，因此，该包中的对象在很大程度上都有相似的不支持公式结构的math包中的对应实现。
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
 * 不可变对象可变是指一个无论是结构还是值或者是其它的状态自构造起就永远不可变。<b>foth包中的所有实现类都是可变的。</b>
 * <br>接收可变对象的对象一定是可变对象，反之，只接收不可变对象的对象不一定是不可变对象。
 * <br>不过，可变对象并不是在任何时候都可编辑，比如一个可变对象接收 {@link com.dwarfeng.dutil.foth.algebra.FothValue}对象，
 * 所以这个对象是可变的对象，然而在传入参数时，却传入几个常量，这样，虽然这个对象是可变对象，却没有任何方法能够修改
 * 这个对象。因此，可变对象继承 {@link com.dwarfeng.dutil.foth.DFoth}接口，并且通过调用
 * {@link com.dwarfeng.dutil.foth.DFoth#canModify()}方法来查询这个类究竟是否可变，由于该包中的实现类都是可变的，所以
 * 该包中的所有实现类都间接继承该接口。
 * 
 * <p><b>关于构造：</b>
 * <br> 此包是数学包，该包中的许多类在math包中都有对应的实现，凡是有这种对应关系的，都会含有如下的构造方法——
 * 入口参数为math包中对应的类，即通过math包中对应的类来生成一个所有元素都是常量的对应的无结构foth对象。
 * 同时，如果拥有上述的对应关系，foth包中的类同样具有可以转化为math类的方法，该方法以to开头，以math包中对应的类名结尾。
 * 
 * <p><b>关于运算（尤其是代数）：</b>
 * <br> 数学包中的运算分为算式运算和值运算。算式运算是通过算式类将不同的对象构造成一个算式，比如代数中的 TODO 算式
 * 算式运算是在保留原有的对象的结构上进行的运算，因此，如果原有对象中含有可变对象，则算式运算也是可变的。
 * 另一种运算是值运算，比如线性代数包中的 {@link com.dwarfeng.dutil.foth.linalge.DefaultFormulaRowVector}，该类具有行向量的运算方法，这些方法是封装在类的内部的
 * 在调用这些方法时，会对对象内在的 {@link com.dwarfeng.dutil.foth.algebra.FothValue} 对象进行取值，返回
 * 的新对象只保留运算之后的值，所以值运算时破坏性的，通过值运算返回的结果不在用于运算元素的特性，即使参与运算的
 * 对象时可变的，通过运算获得的结果对象也同样是不可修改的。
 * 
 * <p> 该包中的计算都是通过 {@link com.dwarfeng.dutil.foth.algebra.FothValue} 进行的，因此，在计算过程中，会对其中的double
 * 进行拆包和封包，造成效率的低下。因此说，这个包不是以运算速度为强项的，该包的意义在于对数学算式可以
 * 进行结构上的保持，并且可以提取变量空间，方便的进行赋值操作。
 * 
 * @author DwArFeng
 * @since 0.0.2-beta
 */
package com.dwarfeng.dutil.foth;
