# Testing the speed of polymorphism in Ruby. This program is based on the Wikipedia article
# http://en.wikipedia.org/wiki/Polymorphism_in_object-oriented_programming

# To run: ruby main.rb <number of runs to time (optional)>
# Example: ruby main.rb 5

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
  runs = ARGV[0] || 1000
  puts "Timing #{runs} run(s) -- this may take a while."

  polymorphic_times = []
  not_polymorphic_times = []

  runs.to_i.times do
    polymorphic_times << time_it(method(:polymorphic))
    not_polymorphic_times << time_it(method(:not_so_polymorphic))
  end
  
  polymorphic_average = polymorphic_times.reduce(:+) / polymorphic_times.size
  not_polymorphic_average = not_polymorphic_times.reduce(:+) / not_polymorphic_times.size

  puts "    polymorphic average: #{polymorphic_average}"
  puts "not polymorphic average: #{not_polymorphic_average}"
end

main
