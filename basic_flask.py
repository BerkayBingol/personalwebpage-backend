from flask import Flask
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'postgres://localhost/personalwp'
db = SQLAlchemy(app)

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(80), unique=True, nullable=False)
    email = db.Column(db.String(120), unique=True, nullable=False)

    def __repr__(self):
        return '<User %r>' % self.username


@app.route('/')
def hello_world():
    return 'Hello, World!'

@app.errorhandler(404)
def page_not_found(error):
    return 'This page does not exist', 404

app.run()

'''
So what did that code do?

1. First we imported the Flask class. An instance of this class will be our WSGI application.
2. Next we create an instance of this class. The first argument is the name of the application’s module or package.
   If you are using a single module (as in this example), you should use __name__ because depending on if it’s started
   as application or imported as module the name will be different ('__main__' versus the actual import name).
   This is needed so that Flask knows where to look for templates, static files, and so on. For more information have a
   look at the Flask documentation.
3. We then use the route() decorator to tell Flask what URL should trigger our function.
4. The function is given a name which is also used to generate URLs for that particular function, and
   returns the message we want to display in the user’s browser.
'''