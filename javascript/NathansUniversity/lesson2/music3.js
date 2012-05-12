var compile = function (musexpr) {
		noteProgram = [];
		timeNow = 0;
		return compileNoteFromMus(musexpr);
};

var compileNoteFromMus = function(musexpr) {
		if ( musexpr.tag === 'note' ) {
				noteProgram.push( generateNoteEntry(musexpr, timeNow) );
				timeNow += musexpr.dur;
		} else if ( musexpr.tag === 'seq' ) {
				compileNoteFromMus( musexpr.left );
				compileNoteFromMus( musexpr.right );
		}
		return noteProgram;
};

var generateNoteEntry = function (expr , t) {
		if ( expr.tag === 'note' ) {
				noteEntry = expr;
				noteEntry.start = t;
				return noteEntry;
		}
};

var endTime = function (time, expr) {
		if ( expr.tag === 'note' ) {
				return time + expr.dur;
		} 
		return endTime( endTime(time, expr.left), expr.right );
};


var melody1_mus = { tag: 'note', pitch: 'a4', dur: 125 };
var melody1_note = [ 
    { tag: 'note', pitch: 'a4', start: 0, dur: 125 } ];
var melody2_mus = 
    { tag: 'seq',
      left: 
       { tag: 'seq',
         left: { tag: 'note', pitch: 'a4', dur: 250 },
         right: { tag: 'note', pitch: 'b4', dur: 250 } },
      right:
       { tag: 'seq',
         left: { tag: 'note', pitch: 'c4', dur: 500 },
         right: { tag: 'note', pitch: 'd4', dur: 500 } } };
var melody2_note = [
    { tag: 'note', pitch: 'a4', start: 0, dur: 250 },
    { tag: 'note', pitch: 'b4', start: 250, dur: 250 },
    { tag: 'note', pitch: 'c4', start: 500, dur: 500 },
    { tag: 'note', pitch: 'd4', start: 1000, dur: 500 } ];


compile(melody1_mus);
compile(melody2_mus);
