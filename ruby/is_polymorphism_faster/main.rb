class Animal
  def initialize(name)
    @name = name
  end
end

class Cat < Animal
  def talk
    "meow"
  end
end

class Cow < Animal
  def talk
    "moo"
  end
end

class Dog < Animal
  def talk
    "bark"
  end
end

def polymorphic
  animals = [Cat.new("kitty"), Cow.new("bessy"), Dog.new("fido")]
  animals.each do |a| 
    a.talk
  end
end

def not_so_polymorphic
  animals = [Cat.new("kitty"), Cow.new("bessy"), Dog.new("fido")]
  animals.each do |a|
    case a
      when Cat
        "meow"
      when Cow
        "moo"
      when Dog
        "bark"
    end
  end
end

def time_it(f, runs=1000000)
  start = Time.now
  runs.times do
    f.call
  end
  total = Time.now - start
end

def main
  polymorphic_times = []
  not_polymorphic_times = []
  runs = 1000

  runs.times do
    polymorphic_times << time_it(method(:polymorphic))
    not_polymorphic_times << time_it(method(:not_so_polymorphic))
  end
  
  polymorphic_average = polymorphic_times.inject(:+) / polymorphic_times.size
  not_polymorphic_average = not_polymorphic_times.inject(:+) / polymorphic_times.size

  p "polymorphic_times = #{polymorphic_average}"
  p "not_polymorphic_times = #{not_polymorphic_average}"
end

main
